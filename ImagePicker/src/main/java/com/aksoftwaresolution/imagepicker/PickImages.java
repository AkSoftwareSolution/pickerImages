package com.aksoftwaresolution.imagepicker;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PickImages {

    private final Activity activity;
    private final ImageView imageView;
    private final OnImagePickedListener listener;
    private final ActivityResultLauncher<String> permissionLauncher;
    private final ActivityResultLauncher<String> pickImageLauncher;

    public interface OnImagePickedListener {
        void onImagePicked(String base64Image);
    }

    public PickImages(Activity activity, ImageView imageView, OnImagePickedListener listener) {
        this.activity = activity;
        this.imageView = imageView;
        this.listener = listener;

        // Permission Request Launcher
        permissionLauncher = ((androidx.activity.ComponentActivity) activity)
                .registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                    if (isGranted) {
                        openGallery();
                    } else {
                        Toast.makeText(activity, "Permission Request filed", Toast.LENGTH_SHORT).show();
                    }
                });

        // Image Picker Launcher
        pickImageLauncher = ((androidx.activity.ComponentActivity) activity)
                .registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        imageView.setImageURI(uri);
                        handleImageUri(uri);
                    }
                });
    }

    // পাবলিক মেথড: ছবি পিক করা শুরু করো
    public void pickIma() {
        String permission;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            permission = Manifest.permission.READ_MEDIA_IMAGES;
        } else {
            permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        }

        if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
            openGallery();
        } else {
            permissionLauncher.launch(permission);
        }
    }

    // গ্যালারি ওপেন করা
    private void openGallery() {
        pickImageLauncher.launch("image/*");
    }

    // Uri থেকে ইমেজ এনকোড করা
    private void handleImageUri(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri);
            String base64 = encodeImage(bitmap);
            listener.onImagePicked(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Bitmap → Base64
    private String encodeImage(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        String encoded = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        Log.d("EncodedImage", encoded);
        return encoded;
    }
}


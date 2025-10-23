# লাইব্রেরির সব ক্লাস রাখো
-keep class com.aksoftwaresolution.imagepicker.** { *; }

# PickImages এর সব মেথড রাখো
-keepclassmembers class com.aksoftwaresolution.imagepicker.** {
    <init>(...);
    void pickIma();
    void handleImageUri(android.net.Uri);
    java.lang.String encodeImage(android.graphics.Bitmap);
}

# Parcelable ক্লাস যদি থাকে, তাদের রাখো
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# লাইব্রেরির inner class রাখো
-keepclassmembers class com.aksoftwaresolution.imagepicker.**$* { *; }

# callback interface এর মেথড রাখো
-keepclassmembers interface com.aksoftwaresolution.imagepicker.PickImages$OnImagePickedListener {
    void onImagePicked(java.lang.String);
}

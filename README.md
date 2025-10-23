
#Step 1. Add the JitPack repository to your build file
Add it in your root settings.gradle at the end of repositories:

```settings.gradle
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

```
#Step 2. Add the dependency

```build.gradle

implementation 'com.github.AkSoftwareSolution:pickerImages:1.1.0'
	
```
#Step 3. Add the AndroidManifest.xml
```AndroidManifest.xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
```
#Step 4. Add the MainActivity.java
```MainActivity.java
package com.aksoftwaresolution.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import com.aksoftwaresolution.pickimages.PickImages;

public class MainActivity extends AppCompatActivity {

    private PickImages pickImages;
    private ImageView imageView;
    private Button pickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        pickBtn = findViewById(R.id.pickBtn);

        // PickImages ক্লাস ইনিশিয়ালাইজ করা
        pickImages = new PickImages(this, imageView, base64Image -> {
            // এখানে তুমি base64 ইমেজ পাবে
            Toast.makeText(this, "Image picked successfully!", Toast.LENGTH_SHORT).show();
            // চাইলে base64 লগেও দেখতে পারো
            // Log.d("BASE64_IMAGE", base64Image);
        });

        // বাটনে ক্লিক করলে গ্যালারি ওপেন হবে
        pickBtn.setOnClickListener(v -> pickImages.pickIma());
    }
}
```




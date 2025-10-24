# 🖼️ pickerImages Android Library  

![Release](https://img.shields.io/badge/version-1.1.1-blue.svg?style=for-the-badge)
![Build](https://img.shields.io/badge/build-passing-brightgreen.svg?style=for-the-badge)
![License](https://img.shields.io/badge/license-Apache%202.0-orange.svg?style=for-the-badge)
![Platform](https://img.shields.io/badge/platform-Android-green.svg?style=for-the-badge)

> ⚡ **A lightweight & modern Android library for picking images from gallery and getting Base64 encoded strings easily.**  
> Made with ❤️ by **Ak Software Solution**

| Feature                 | Description                                      |
| ----------------------- | ------------------------------------------------ |
| 🖼️ Image Picker        | Pick any image from device gallery easily        |
| ⚡ Base64 Output         | Returns image as Base64 encoded string instantly |
| 🧠 Auto Permission      | Handles permission checks automatically          |
| 🪶 Lightweight          | No extra dependencies or heavy code              |
| 📱 Android 13+ Support  | Includes `READ_MEDIA_IMAGES` permission          |
| 💾 Save or Upload Ready | Perfect for APIs or image upload logic           |



---

## 📦 Installation  

### 🧩 Step 1 — Add JitPack Repository

Add it in your settings.gradle.kts at the end of repositories:
```settings.gradle.kts
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
```

Add this inside your **`settings.gradle`** file:  

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
🧩 Step 2 — Add the Dependency
Add this line inside your build.gradle.kts (Module: app) file:
```gradle.kts

    implementation("com.github.AkSoftwareSolution:pickerImages:1.1.1")

```
Add this line inside your build.gradle(Module: app) file:
```build.gradle
implementation 'com.github.AkSoftwareSolution:pickerImages:1.1.1'
```
⚙️ Permissions
Add these permissions inside your AndroidManifest.xml:
✅ Note: READ_MEDIA_IMAGES permission is required for Android 13 (API 33) and above.
```AndroidManifest.xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
```
🧩Example Layout (activity_main.xml)
```activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_gravity="center"
        android:scaleType="centerCrop"
        android:src="@drawable/ic_launcher_background" />

    <Button
        android:id="@+id/pickBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pick Image"
        android:layout_gravity="center"
        android:layout_marginTop="20dp"/>
</LinearLayout>
```
💡 Example Usage (MainActivity.java)
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

        // Initialize PickImages
        pickImages = new PickImages(this, imageView, base64Image -> {
            Toast.makeText(this, "Image picked successfully!", Toast.LENGTH_SHORT).show();
            // You can also log the Base64 string:
            // Log.d("BASE64_IMAGE", base64Image);
        });

        // Open gallery when button is clicked
        pickBtn.setOnClickListener(v -> pickImages.pickIma());
    }
}
```
🛡️ ProGuard / R8

#This library already includes a consumer-rules.pro, so if you use ProGuard or R8, no extra configuration is needed.

It automatically preserves:
All public API classes and methods
Inner classes like result callbacks
Kotlin metadata (if using Kotlin)
Removes unnecessary Log statements in release builds




###🧠 Requirements
| Component                 | Version                  |
| ------------------------- | ------------------------ |
| **Android Gradle Plugin** | 7.0.0+                   |
| **Gradle Version**        | 7.0+                     |
| **Min SDK**               | 21                       |
| **Target SDK**            | 34                       |
| **Language**              | Java / Kotlin Compatible |


🧪 Example Output

When a user selects an image:
```Image
Image picked successfully!
```

✅ Base64 string is returned in the callback function.




## 🧑‍💻 Developed by

<table align="center">
  <tr>
    <td align="center">
      <h3>🧩 <b>Ak Software Solution</b></h3>
      <p>
        📦 <a href="https://github.com/AkSoftwareSolution/pickerImages" target="_blank">GitHub Repository</a> <br>
        🌐 <a href="https://aksoftwaresolution.github.io" target="_blank">Website</a> (optional) <br>
        💬 If you like this library, don’t forget to ⭐ it on GitHub!
      </p>
    </td>
  </tr>
</table>


🪄 License
``` License

Copyright (c) 2025 Ak Software Solution

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```












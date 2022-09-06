package com.example.studiomillefeuilles;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ActivityChoixPersoResto extends AppCompatActivity {

    private TextView btnPhoto;
    private TextView btnGalerie;
    private ImageView leftIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_perso_resto);
        btnPhoto = (TextView) findViewById(R.id.btnPhoto);

        btnPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                activityResultLauncherPhoto.launch(camera_intent);
            }
        });

        btnGalerie = findViewById(R.id.btnGalerie);

        btnGalerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallerie_Intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                gallerie_Intent.setType("image/*");
                activityResultLauncherGalerie.launch(gallerie_Intent);
            }
        });

        this.leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(),ActivityChoix2.class);
                startActivity(otherActivity);
                finish();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

    }
    public String createImageFromBitmap(Bitmap bitmap) {
        String fileName = "myImage";//no .png or .jpg needed
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);


            FileOutputStream fo = openFileOutput(fileName, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            // remember close file output
            fo.close();
            System.out.println(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            fileName = null;
        }
        return fileName;
    }

    ActivityResultLauncher<Intent> activityResultLauncherPhoto = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    int result = activityResult.getResultCode();
                    Intent data = activityResult.getData();

                    if (result == RESULT_OK) {

                        Bitmap photo = (Bitmap) data.getExtras()
                                .get("data");
                        createImageFromBitmap(photo);
                        Intent newActivity = new Intent(ActivityChoixPersoResto.this,ImportationPhotoPersoResto.class);
                        startActivity(newActivity);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> activityResultLauncherGalerie = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    int result = activityResult.getResultCode();
                    Intent data = activityResult.getData();

                    if (result == RESULT_OK) {

                        try {
                            Uri imageUri = data.getData();
                            InputStream imageStream = getContentResolver().openInputStream(imageUri);
                            Bitmap photo = (Bitmap) BitmapFactory.decodeStream(imageStream);

                            createImageFromBitmap(photo);
                            Intent newActivity = new Intent(ActivityChoixPersoResto.this,ImportationPhotoPersoResto.class);
                            startActivity(newActivity);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

}
package com.example.studiomillefeuilles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ImportationPhoto extends AppCompatActivity {


    private ImageView imageSelect;
    private TextView btnImport;
    private Bitmap bitmap;
    private ImageView leftIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importation_photo);
        try {
            bitmap = BitmapFactory.decodeStream(openFileInput("myImage"));//here context can be anything like getActivity() for fragment, this or MainActivity.this

            imageSelect = findViewById(R.id.imageSelect);

            imageSelect.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        btnImport = findViewById(R.id.btnImport);
        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap = scaleBitmap(bitmap);
                createImageFromBitmap(bitmap);
                Intent newActivity = new Intent(ImportationPhoto.this, PropositionVectorisation.class);
                startActivity(newActivity);
            }
        });
        this.leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(),ActivityChoix.class);
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
        for(int i=1; i<5; i++) {
            String fileName = "vecto"+ i;//no .png or .jpg needed
            try {
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                FileOutputStream fo = openFileOutput(fileName, Context.MODE_PRIVATE);
                fo.write(bytes.toByteArray());
                // remember close file output
                fo.close();
            } catch (Exception e) {
                e.printStackTrace();
                fileName = null;
            }
        }
        return null;
    }

    public Bitmap scaleBitmap(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();

        Log.v("Pictures", "Width and height are " + width + "--" + height);

        if (width > height) {
            //landscape
            float ratio = (float) width / 400;
            width = 400;
            height = (int) (height / ratio);
        } else if (height > width) {
            //portrait
            float ratio = (float) height / 400;
            height = 400;
            width = (int) (width / ratio);
        } else {
            //square
            height = 400;
            width = 400;
        }
        bm = Bitmap.createScaledBitmap(bm, width, height, true);
        return bm;
    }
}
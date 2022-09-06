package com.example.studiomillefeuilles;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class PropositionVectorisationPersoResto extends AppCompatActivity {

    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap bitmap3;
    private Bitmap bitmap4;
    private ImageView vecto1;
    private ImageView vecto2;
    private ImageView vecto3;
    private ImageView vecto4;
    private ImageView choix1;
    private ImageView choix2;
    private ImageView choix3;
    private ImageView choix4;
    private ImageView leftIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition_vectorisation_perso_resto);

        choix1 = findViewById(R.id.btnVecto1);
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(PropositionVectorisationPersoResto.this, VisualisationPersoResto.class);
                newActivity.putExtra("i","1");
                startActivity(newActivity);
            }
        });

        choix2 = findViewById(R.id.btnVecto2);
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(PropositionVectorisationPersoResto.this, VisualisationPersoResto.class);
                newActivity.putExtra("i","2");
                startActivity(newActivity);
            }
        });

        choix3 = findViewById(R.id.btnVecto3);
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(PropositionVectorisationPersoResto.this, VisualisationPersoResto.class);
                newActivity.putExtra("i","3");
                startActivity(newActivity);
            }
        });

        choix4 = findViewById(R.id.btnVecto4);
        choix4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(PropositionVectorisationPersoResto.this, VisualisationPersoResto.class);
                newActivity.putExtra("i","4");
                startActivity(newActivity);
            }
        });

        try {

            bitmap1 = BitmapFactory.decodeStream(openFileInput("vecto1"));//here context can be anything like getActivity() for fragment, this or MainActivity.this
            bitmap1 = bitmap1.copy( Bitmap.Config.ARGB_8888 , true);
            vecto1 = findViewById(R.id.vecto1);
            vecto1.setImageBitmap(bitmap1);
            imgNoir1();

            bitmap2 = BitmapFactory.decodeStream(openFileInput("vecto2"));//here context can be anything like getActivity() for fragment, this or MainActivity.this
            bitmap2 = bitmap2.copy( Bitmap.Config.ARGB_8888 , true);
            vecto2 = findViewById(R.id.vecto2);
            vecto2.setImageBitmap(bitmap2);
            imgNoir2();

            bitmap3 = BitmapFactory.decodeStream(openFileInput("vecto3"));//here context can be anything like getActivity() for fragment, this or MainActivity.this
            bitmap3 = bitmap3.copy( Bitmap.Config.ARGB_8888 , true);
            vecto3 = findViewById(R.id.vecto3);
            vecto3.setImageBitmap(bitmap3);
            imgNoir3();

            bitmap4 = BitmapFactory.decodeStream(openFileInput("vecto4"));//here context can be anything like getActivity() for fragment, this or MainActivity.this
            bitmap4 = bitmap4.copy( Bitmap.Config.ARGB_8888 , true);
            vecto4 = findViewById(R.id.vecto4);
            vecto4.setImageBitmap(bitmap4);
            imgNoir4();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(),ImportationPhotoPersoResto.class);
                startActivity(otherActivity);
                finish();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
    }
    @SuppressLint("ResourceAsColor")
    private void imgNoir1(){

        for(int x=0; x<bitmap1.getWidth(); x++) {
            for (int y = 0; y < bitmap1.getHeight(); y++) {
                int pixel = bitmap1.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 190){
                    bitmap1.setPixel(x,y, Color.BLACK);
                }else{
                    bitmap1.setPixel(x,y,Color.WHITE);
                }
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    private void imgNoir2(){

        for(int x=0; x<bitmap2.getWidth(); x++) {
            for (int y = 0; y < bitmap2.getHeight(); y++) {
                int pixel = bitmap2.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 180){
                    bitmap2.setPixel(x,y, Color.BLACK);
                }else{
                    bitmap2.setPixel(x,y,Color.WHITE);
                }
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    private void imgNoir3(){

        for(int x=0; x<bitmap3.getWidth(); x++) {
            for (int y = 0; y < bitmap3.getHeight(); y++) {
                int pixel = bitmap3.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 170){
                    bitmap3.setPixel(x,y, Color.BLACK);
                }else{
                    bitmap3.setPixel(x,y,Color.WHITE);
                }
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    private void imgNoir4(){

        for(int x=0; x<bitmap4.getWidth(); x++) {
            for (int y = 0; y < bitmap4.getHeight(); y++) {
                int pixel = bitmap4.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 160){
                    bitmap4.setPixel(x,y, Color.BLACK);
                }else{
                    bitmap4.setPixel(x,y,Color.WHITE);
                }
            }
        }
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
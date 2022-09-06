package com.example.studiomillefeuilles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileNotFoundException;


public class HomeFragmentPersoResto extends Fragment{

    private TextView retourMain;
    private ImageView imgVecto;
    private ImageView imgTransparant;
    private Bitmap bitmap;
    private Bitmap bitmap2;
    private String i;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_perso_resto, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        imgTransparant=getView().findViewById(R.id.imgTrans);
        imgVecto=getView().findViewById(R.id.imgVecto);
        retourMain= getView().findViewById(R.id.btnRetourMain);
        retourMain.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent newActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(newActivity);
            }
        });

        Intent intent = getActivity().getIntent();
        if(intent != null){
            if (intent.hasExtra("i")){ // vérifie qu'une valeur est associée à la clé “edittext”
                i = intent.getStringExtra("i"); // on récupère la valeur associée à la clé
            }
        }

        try {
            bitmap = BitmapFactory.decodeStream(getActivity().openFileInput("vecto1"));//here context can be anything like getActivity() for fragment, this or MainActivity.this
            bitmap = bitmap.copy( Bitmap.Config.ARGB_8888 , true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scaleBitmap(bitmap);


        if(i.equals("1")){
            imgNoir1();
        }else if(i.equals("2")){
            imgNoir2();
        }else if(i.equals("3")){
            imgNoir3();
        }else if(i.equals("4")){
            imgNoir4();
        }

        imgVecto = getView().findViewById(R.id.imgVecto);
        imgVecto.setImageBitmap(bitmap);

    }


    public Bitmap scaleBitmap(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();

        if (width > height) {
            //landscape
            float ratio = (float) width / 800;
            width = 800;
            height = (int) (height / ratio);
            imgTransparant.getLayoutParams().height = height;
            imgTransparant.getLayoutParams().width = width;
            imgVecto.getLayoutParams().height = height;
            imgVecto.getLayoutParams().width = width;

        } else if (height > width) {
            //portrait
            float ratio = (float) height / 800;
            height = 800;
            width = (int) (width / ratio);
            imgTransparant.getLayoutParams().height = height;
            imgTransparant.getLayoutParams().width = width;
            imgVecto.getLayoutParams().height = height;
            imgVecto.getLayoutParams().width = width;
        } else {
            //square
            height = 800;
            width = 800;
            imgTransparant.getLayoutParams().height = height;
            imgTransparant.getLayoutParams().width = width;
            imgVecto.getLayoutParams().height = height;
            imgVecto.getLayoutParams().width = width;
        }
        bm = Bitmap.createScaledBitmap(bm, width, height, true);



        return bm;

    }


    @SuppressLint("ResourceAsColor")
    private void imgNoir1(){

        for(int x=0; x<bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                int pixel = bitmap.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 190){
                    bitmap.setPixel(x,y, Color.TRANSPARENT);
                }else{
                    bitmap.setPixel(x,y, Color.WHITE);
                }
            }
        }
    }


    @SuppressLint("ResourceAsColor")
    private void imgNoir2(){

        for(int x=0; x<bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                int pixel = bitmap.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 180){
                    bitmap.setPixel(x,y, Color.TRANSPARENT);
                }else{
                    bitmap.setPixel(x,y, Color.WHITE);
                }
            }
        }
    }
    /**Color.argb(255,239,207,169)**/

    @SuppressLint("ResourceAsColor")
    private void imgNoir3(){

        for(int x=0; x<bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                int pixel = bitmap.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 170){
                    bitmap.setPixel(x,y, Color.TRANSPARENT);
                }else{
                    bitmap.setPixel(x,y, Color.WHITE);
                }
            }
        }
    }


    @SuppressLint("ResourceAsColor")
    private void imgNoir4(){

        for(int x=0; x<bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                int pixel = bitmap.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int gris = (int) (0.299*red + 0.587*green + 0.114*blue);

                if(gris <= 160){
                    bitmap.setPixel(x,y, Color.TRANSPARENT);
                }else{
                    bitmap.setPixel(x,y, Color.WHITE);
                }
            }
        }
    }
}

package com.example.studiomillefeuilles;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;


public class MainActivity extends AppCompatActivity {

    private GifImageView btnSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.btnSuivant = (GifImageView) findViewById(R.id.btnSuivant);

        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), ActivityChoix2.class );
                startActivity(otherActivity);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }

        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }



    }
}

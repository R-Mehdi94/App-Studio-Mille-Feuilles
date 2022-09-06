package com.example.studiomillefeuilles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityChoix2 extends AppCompatActivity {

    private TextView btnPersoResto;
    private TextView btnSerigraphie;
    private ImageView leftIcon;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix2);

        this.btnSerigraphie = (TextView) findViewById(R.id.btnSerigraphie);

        btnSerigraphie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ActivityChoix.class);
                startActivity(otherActivity);
            }
        });

        this.btnPersoResto = (TextView) findViewById(R.id.btnPersoResto);

        btnPersoResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ActivityChoixPersoResto.class);
                startActivity(otherActivity);
            }
        });
        this.leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
    }

}
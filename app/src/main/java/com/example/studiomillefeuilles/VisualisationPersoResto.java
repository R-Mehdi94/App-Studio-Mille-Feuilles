package com.example.studiomillefeuilles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
public class VisualisationPersoResto extends AppCompatActivity {

    private Bitmap bitmap;
    private String i;

    ViewPagerFragmentAdapterB viewPagerFragmentAdapterB;
    TabLayout tabLayout2;
    ViewPager2 viewPager2;


    private String[] titles=new String[]{"Contours","Gravé"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisation_perso_resto);

        getSupportActionBar().hide();
        viewPager2=findViewById(R.id.view_pager2);
        tabLayout2=findViewById(R.id.tab_Layout2);
        viewPagerFragmentAdapterB=new ViewPagerFragmentAdapterB(this);

        viewPager2.setAdapter(viewPagerFragmentAdapterB);
        new TabLayoutMediator(tabLayout2,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

    }

}
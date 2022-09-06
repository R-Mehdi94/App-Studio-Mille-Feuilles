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

public class Visualisation extends AppCompatActivity {

    private Bitmap bitmap;
    private String i;

    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String[] titles= new String[]{"Pancake","Pita","Pain de mie","3"};

    int test = titles.length;


    public Visualisation() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisation);

        getSupportActionBar().hide();
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_Layout);
        viewPagerFragmentAdapter=new ViewPagerFragmentAdapter(this);

        viewPager.setAdapter(viewPagerFragmentAdapter);
        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setText(titles[position]))).attach();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

    }

}
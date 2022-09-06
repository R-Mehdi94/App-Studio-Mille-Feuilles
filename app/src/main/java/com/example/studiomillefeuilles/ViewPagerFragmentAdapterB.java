package com.example.studiomillefeuilles;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerFragmentAdapterB extends FragmentStateAdapter {

    private String[] titles=new String[]{"testA","testB"};

    public ViewPagerFragmentAdapterB(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragmentPersoResto();
            case 1:
                return new SecondFragmentPersoResto();
        }
        return new HomeFragmentPersoResto();
    }

    @Override
    public int getItemCount() {return titles.length;}
}

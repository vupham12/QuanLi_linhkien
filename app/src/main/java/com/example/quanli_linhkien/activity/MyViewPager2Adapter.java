package com.example.quanli_linhkien.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanli_linhkien.fragment.FavoriteFragment;
import com.example.quanli_linhkien.fragment.HistoryFragment;
import com.example.quanli_linhkien.fragment.HomeFragment;

public class MyViewPager2Adapter extends FragmentStateAdapter {

    public MyViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return  new HomeFragment();
            case 1:
                return  new FavoriteFragment();
            case 2:
                return  new HistoryFragment();
            default:
                return  new HomeFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

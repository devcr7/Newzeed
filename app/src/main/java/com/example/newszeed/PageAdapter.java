package com.example.newszeed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home();
            case 1:
                return new Health();
            case 2:
                return new Entertainment();
            case 3:
                return new Sports();
            case 4:
                return new Science();
            case 5:
                return new Technology();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

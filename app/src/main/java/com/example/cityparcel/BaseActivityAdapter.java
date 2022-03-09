package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BaseActivityAdapter extends FragmentPagerAdapter {
    public BaseActivityAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Home_fragment();
            case 1:
                return new MyCartFragment();
            case 2:
                return new DinningFragment();
            case 3:
                return new MyAccountFragment();
            default:
                return new Home_fragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "My Cart";
            case 2:
                return "Diining";
            case 3:
                return "My Account";
            default:
                return "";
        }
    }
}

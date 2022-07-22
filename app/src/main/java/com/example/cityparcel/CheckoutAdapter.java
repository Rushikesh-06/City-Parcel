package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class CheckoutAdapter extends FragmentPagerAdapter {


    public CheckoutAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new checkout_addressfragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}

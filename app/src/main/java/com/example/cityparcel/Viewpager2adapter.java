package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cityparcel.aboutus;
import com.example.cityparcel.menu;
import com.example.cityparcel.photos;
import com.example.cityparcel.review;

public class Viewpager2adapter extends FragmentStateAdapter {
    public Viewpager2adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public Viewpager2adapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public Viewpager2adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new menu();
            case 1:
                return new photos();
            case 2:
                return new review();
            case 3:
                return new aboutus();


        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

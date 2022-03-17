package com.example.cityparcel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class RestaurantDetails extends Fragment {
    private String TAG = getClass().getSimpleName();
    LinearLayout bottomsheet_ll;
    CardView cardview_bs;
    ViewPager2 bottomsheetpager2;
    TabLayout bottomsheettablayout;
    TextView bs_title;
    ImageView imageview_bs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resto_details, container, false);

        bottomsheet_ll = view.findViewById(R.id.bottomsheet_ll);
        bottomsheetpager2 = view.findViewById(R.id.bottomsheetpager2);
        bottomsheettablayout = view.findViewById(R.id.bottomsheettablayout);
        cardview_bs = view.findViewById(R.id.cardview_bs);
        bs_title = view.findViewById(R.id.bs_title);
        imageview_bs = view.findViewById(R.id.imageview_bs);

        Viewpager2adapter viewpager2adapter = new Viewpager2adapter(RestaurantDetails.this);
        bottomsheetpager2.setAdapter(viewpager2adapter);

        new TabLayoutMediator(bottomsheettablayout, bottomsheetpager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Menu");
                    break;
                case 1:
                    tab.setText("Photos");
                    break;
                case 2:
                    tab.setText("Review");
                    break;
                case 3:
                    tab.setText("About Us");
                    break;
            }
        }
        ).attach();


        //setting bottom layout
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(cardview_bs);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


        //getting values and setting values
        Bundle bundle = getArguments();
        if (bundle.containsKey("title")) {
            Log.e(TAG, "onCreateView: " + bundle.getString("title"));
        }
        bs_title.setText(bundle.getString("title"));
        imageview_bs.setImageResource(bundle.getInt("image"));



        return view;
    }
}


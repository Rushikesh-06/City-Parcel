package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;


public class Framlist_fragment extends Fragment {

    RecyclerView farmlist_rv;
    FrameLayout farmlist_frame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_framlist_fragment, container, false);

        farmlist_rv = view.findViewById(R.id.farmlist_rv);
        farmlist_frame = view.findViewById(R.id.farmlist_frame);

        farmlist_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        farmlist_rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        List<DetaillistFarmGift_class> list = new ArrayList<>();

        list.add(new DetaillistFarmGift_class("Fresh Farm Grapes","\t&#8377; 200/kg",R.drawable.grapes));
        list.add(new DetaillistFarmGift_class("Fresh Carrots","\t&#8377; 50/kg",R.drawable.carrots));
        list.add(new DetaillistFarmGift_class("Fresh Mangoes","\t&#8377; 400/kg",R.drawable.mango));
        list.add(new DetaillistFarmGift_class("Fresh Apples","\t&#8377; 250/kg",R.drawable.apple));
        list.add(new DetaillistFarmGift_class("Fresh Watermelon","\t&#8377; 90/pcs",R.drawable.watermelon));
        list.add(new DetaillistFarmGift_class("Fresh Strawberry","\t&#8377; 300/kg",R.drawable.strawberry));
        list.add(new DetaillistFarmGift_class("Fresh Coconuts","\t&#8377; 80/pcs",R.drawable.coconut));
        list.add(new DetaillistFarmGift_class("Fresh Banana","\t&#8377; 60/dozen",R.drawable.banana));
        farmlist_rv.setAdapter(new Detaillist_framgiftadapter(getContext(),list));



        return view;
    }
}
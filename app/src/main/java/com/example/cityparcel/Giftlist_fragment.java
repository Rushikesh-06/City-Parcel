package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class Giftlist_fragment extends Fragment {

    RecyclerView giftlist_rv;
    FrameLayout giftlist_frame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_giftlist_fragment, container, false);

        giftlist_rv = view.findViewById(R.id.giftlist_rv);
        giftlist_frame = view.findViewById(R.id.giftlist_frame);


        giftlist_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        giftlist_rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        List<DetaillistFarmGift_class> giftitem_list = new ArrayList<>();

        giftitem_list.add(new DetaillistFarmGift_class("Wooden Toy Cars", "\t&#8377; 200 ", R.drawable.woodentoy));
        giftitem_list.add(new DetaillistFarmGift_class("Wall Painting", "\t&#8377; 350 ", R.drawable.handmadepainting));
        giftitem_list.add(new DetaillistFarmGift_class("Home Wall Frame", "\t&#8377; 190 ", R.drawable.wallframe));
        giftitem_list.add(new DetaillistFarmGift_class("Soft Toy Set", "\t&#8377; 350 ", R.drawable.softtpys));
        giftitem_list.add(new DetaillistFarmGift_class("MVMT Watch", "\t&#8377; 2000 ", R.drawable.watches));
        giftitem_list.add(new DetaillistFarmGift_class("Monk Statues", "\t&#8377; 400 ", R.drawable.showcase));
        giftitem_list.add(new DetaillistFarmGift_class("Womens Make Up Set", "\t&#8377; 750 ", R.drawable.makeup));
        giftitem_list.add(new DetaillistFarmGift_class("Denim Shirt", "\t&#8377; 1200 ", R.drawable.denimshirt));
        giftitem_list.add(new DetaillistFarmGift_class("Nike Air Jordan", "\t&#8377; 4500 ", R.drawable.nikeairjordan));
        giftitem_list.add(new DetaillistFarmGift_class("Boat Rockerzs 510", "\t&#8377; 1299 ", R.drawable.boat510));
        giftitem_list.add(new DetaillistFarmGift_class("Bottle Plant", "\t&#8377; 300 ", R.drawable.bottleplant));
        giftitem_list.add(new DetaillistFarmGift_class("Ganpati Statue", "\t&#8377; 450 ", R.drawable.ganpati));

        giftlist_rv.setAdapter(new Detaillist_framgiftadapter(getContext(),giftitem_list));

        return view;
    }
}
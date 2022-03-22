package com.example.cityparcel;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Home_fragment extends Fragment {
    RecyclerView restolist;
    RecyclerView homemade_list;
    RecyclerView farmfood_list;
    RecyclerView gift_item;
    RecyclerView scrollimages_head;
    TextView viewall_homemade,viewall_resto,viewall_farm,viewall_gift;
    LinearLayout restofood_layout,homemadefood_layout,farmfood_layout,giftitem_layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        restolist = view.findViewById(R.id.restolist);
        homemade_list = view.findViewById(R.id.homemade_list);
        farmfood_list = view.findViewById(R.id.FarmFood_list);
        gift_item = view.findViewById(R.id.GiftItem_list);
        scrollimages_head = view.findViewById(R.id.scrollimages_head);
        viewall_homemade = view.findViewById(R.id.viewall_homemade);
        viewall_resto = view.findViewById(R.id.viewall_resto);
        restofood_layout = view.findViewById(R.id.restofood_layout);
        homemadefood_layout = view.findViewById(R.id.homemadefood_layout);
        farmfood_layout = view.findViewById(R.id.farmfood_layout);
        giftitem_layout = view.findViewById(R.id.giftitem_layout);
        viewall_farm = view.findViewById(R.id.viewall_farm);
        viewall_gift = view.findViewById(R.id.viewall_gift);
        
        BaseActivity activity =(BaseActivity)getActivity() ;
        activity.location.setText("City Parcel");


        //open fragment of detaillist
        viewall_homemade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gotonext_fragment = new Intent(getActivity(),DeatilList_activity.class);
//                startActivity(gotonext_fragment);
//                getActivity();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, new DeatilList_fragment(), null)
                        .commit();
            }
        });

        homemadefood_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gotonext_fragment = new Intent(getActivity(),DeatilList_activity.class);
//                startActivity(gotonext_fragment);
//                getActivity();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, DeatilList_fragment.class, null)
                        .commit();
            }
        });



        //open resto  food fragment

        viewall_resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, restolist_fragment.class, null)
                        .commit();
            }
        });

        restofood_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, restolist_fragment.class, null)
                        .commit();
            }
        });


        //open farm product fragment

        viewall_farm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, Framlist_fragment.class, null)
                        .commit();
            }
        });

        farmfood_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, Framlist_fragment.class, null)
                        .commit();
            }
        });

        //open gift item fragment
        viewall_gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, Giftlist_fragment.class, null)
                        .commit();
            }
        });

        giftitem_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe, Giftlist_fragment.class, null)
                        .commit();
            }
        });




        //scoll image at starting recycler view
        scrollimages_head.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Integer> scroll_imagelist = new ArrayList<>();
        scroll_imagelist.add(R.drawable.restoslider);
        scroll_imagelist.add(R.drawable.hommadeslider);
        scroll_imagelist.add(R.drawable.farmproductslider);
        scroll_imagelist.add(R.drawable.giftslider);
        scrollimages_head.setAdapter(new ScrollimageAdapter(getContext(), scroll_imagelist));


        //nearby hotel list
        restolist.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant("Hotel Alpha", "Best For Any Party Occasion...", "20-25 min", 4.5, R.drawable.alpha));
        list.add(new Restaurant("Shivraj Dhaba", "Famous Akkha Masoor...", "30 min", 4.5, R.drawable.shivraj));
        list.add(new Restaurant("Hotel Taj", "Mumbai's Identity Visit Once...", "40-45 min", 4.5, R.drawable.taj));
        list.add(new Restaurant("KFC", "It's finger lickin' good..", "20 min", 4.5, R.drawable.kfc));
        list.add(new Restaurant("Mc Donalds", "i'm loving it !", "25 min", 4.5, R.drawable.mcdy));
        list.add(new Restaurant("Hotel Nisarg", "Surrounded by Nature experience it.", "30 min", 4.5, R.drawable.nisarg));
        list.add(new Restaurant("Bhau VadaPav", "Mumbai's Famous Bhau Vada Pav", "25 min", 4.5, R.drawable.vadapav));
        list.add(new Restaurant("Shivneri Misal", "Spicy Misal,it's hot", "30 min", 4.5, R.drawable.misalpav));
        list.add(new Restaurant("Natural Ice Creams", "Natures Taste in every bite", "20 min", 4.5, R.drawable.natural_icecream));
        restolist.setAdapter(new RestoListAdapter(getContext(), list));


        //homemade food list
        homemade_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Restaurant> HomemadeFood_list = new ArrayList<>();
        HomemadeFood_list.add(new Restaurant("Adisha tiffin service", "Tastes Home made Food", "10", 4.5, R.drawable.tiffin));
        HomemadeFood_list.add(new Restaurant("Gavran Poli Bhaji Kendra", "Proper Vilage Taste like your at hometown", "10", 4.5, R.drawable.polibhaji));
        HomemadeFood_list.add(new Restaurant("Aaba Cha Dhaba", "Open 24x7", "10", 4.5, R.drawable.aaba));
        HomemadeFood_list.add(new Restaurant("Zunka Bhakri Special", "Specially For Zunka Bhakri", "10", 4.5, R.drawable.zunkabhakri));
        HomemadeFood_list.add(new Restaurant("South Indian Food Kendra", "Missing Idli Vada ,then Come And Enjoy", "10", 4.5, R.drawable.southindian));
        HomemadeFood_list.add(new Restaurant("Aai's Bhojnalay", "Tastes Like Mothers hand made food", "10", 4.5, R.drawable.bhojnalay));
        HomemadeFood_list.add(new Restaurant("Anna's Lunch katta", "Non Veg Famous", "10", 4.5, R.drawable.nonveg));
        HomemadeFood_list.add(new Restaurant("Softhub Khanaval", "A taste that you will remember.", "10", 4.5, R.drawable.khanaval));
        HomemadeFood_list.add(new Restaurant("Vanita Lunch Home", "Better food better mood", "10", 4.5, R.drawable.lunch));
        homemade_list.setAdapter(new RestoListAdapter(getContext(), HomemadeFood_list));


        //farm products list
        farmfood_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<FarmGiftClass> farmfoodlist = new ArrayList<>();
        farmfoodlist.add(new FarmGiftClass("Fresh Farm Grapes", "\t&#8377; 200 Per/KG", R.drawable.grapes));
        farmfoodlist.add(new FarmGiftClass("Fresh Carrots", "\t&#8377; 50 Per/KG", R.drawable.carrots));
        farmfoodlist.add(new FarmGiftClass("Fresh Mangoes", "\t&#8377; 400 Per/KG", R.drawable.mango));
        farmfoodlist.add(new FarmGiftClass("Fresh Apples", "\t&#8377; 250 Per/KG", R.drawable.apple));
        farmfoodlist.add(new FarmGiftClass("Fresh Strawberry", "\t&#8377; 300 Per/KG", R.drawable.strawberry));
        farmfoodlist.add(new FarmGiftClass("Fresh Green Coconuts", "\t&#8377; 80 Per/pcs", R.drawable.coconut));
        farmfoodlist.add(new FarmGiftClass("Fresh Banana", "\t&#8377; 60 Per/dozen", R.drawable.banana));
        farmfoodlist.add(new FarmGiftClass("Fresh Watermelon", "\t&#8377; 90 Per/pcs", R.drawable.watermelon));
        farmfood_list.setAdapter(new FarmGiftAdapter(getContext(), farmfoodlist));


        //gift products list
        gift_item.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<FarmGiftClass> giftitem_list = new ArrayList<>();
        giftitem_list.add(new FarmGiftClass("Wooden Toy Cars", "\t&#8377; 200 ", R.drawable.woodentoy));
        giftitem_list.add(new FarmGiftClass("Wall Painting", "\t&#8377; 350 ", R.drawable.handmadepainting));
        giftitem_list.add(new FarmGiftClass("Home Wall Frame", "\t&#8377;  ", R.drawable.wallframe));
        giftitem_list.add(new FarmGiftClass("Soft Toy Set", "\t&#8377;  ", R.drawable.softtpys));
        giftitem_list.add(new FarmGiftClass("MVMT Watch", "\t&#8377;  ", R.drawable.watches));
        giftitem_list.add(new FarmGiftClass("Monk Statues", "\t&#8377;  ", R.drawable.showcase));
        giftitem_list.add(new FarmGiftClass("Womens Make Up Set", "\t&#8377;  ", R.drawable.makeup));
        giftitem_list.add(new FarmGiftClass("Denim Shirt", "\t&#8377;  ", R.drawable.denimshirt));
        giftitem_list.add(new FarmGiftClass("Nike Air Jordan", "\t&#8377;  ", R.drawable.nikeairjordan));

        gift_item.setAdapter(new FarmGiftAdapter(getContext(), giftitem_list));


        return view;


    }
}
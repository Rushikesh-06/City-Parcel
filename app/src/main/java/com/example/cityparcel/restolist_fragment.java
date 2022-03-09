package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;


public class restolist_fragment extends Fragment {

    RecyclerView restolist_rv;
    FrameLayout restolist_frame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=  inflater.inflate(R.layout.fragment_restolist_fragment, container, false);

        restolist_rv = view.findViewById(R.id.restolist_rv);
        restolist_frame = view.findViewById(R.id.restolist_frame);

        restolist_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        restolist_rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        List<DeatillistClass> list = new ArrayList<>();

        list.add(new DeatillistClass("Hotel Alpha", "Best For Any Party Occasion...", "\t&#8377; 300  for one", "10-20 min", R.drawable.alpha));
        list.add(new DeatillistClass("Shivraj Dhaba", "Famous Akkha Masoor... Kaju Curry,Veg Kolhapuri,etc.", "\t&#8377;   for one", "10-20 min", R.drawable.shivraj));
        list.add(new DeatillistClass("Hotel Taj", "Very Luxirious Hotel in Mumbai", "\t&#8377;  500 for one", "10-20 min", R.drawable.taj));
        list.add(new DeatillistClass("KFC", "American fast food restaurant,specializes in fried chicken", "\t&#8377; 150-200  for one", "10-20 min", R.drawable.kfc));
        list.add(new DeatillistClass("Mc Donalds", "We don't just serve food, we serve moments of feel-good", "\t&#8377;  100 for one", "10-20 min", R.drawable.mcdy));
        list.add(new DeatillistClass("Hotel Nisarg", "Surrounded by Nature experience it.", "\t&#8377;  200 for one", "10-20 min", R.drawable.nisarg));
        list.add(new DeatillistClass("Bhau VadaPav", "Mumbai's Famous Bhau Vada Pav,Misal,etc.", "\t&#8377; 50  for one", "10-15 min", R.drawable.vadapav));
        list.add(new DeatillistClass("Shivneri Misal", "Nashik's famous Spicy misal", "\t&#8377; 80 for one", "10-20 min", R.drawable.misalpav));
        list.add(new DeatillistClass("Natural Ice Creams", "Various flavous available,icecreams,milk shake ,kulfi and also dairy products", "\t&#8377; 100  for one", "10-20 min", R.drawable.natural_icecream));
        restolist_rv.setAdapter(new DetailListAdapter(getContext(), list));




        return view;
    }
}
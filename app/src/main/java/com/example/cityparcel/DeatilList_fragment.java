package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class DeatilList_fragment extends Fragment {

    RecyclerView detaillist_RV;
    FrameLayout detailListFrame;
    ImageView favorite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deatil_list_fragment, container, false);

        detaillist_RV = view.findViewById(R.id.detaillist_rv);
        detailListFrame = view.findViewById(R.id.detailListFrame);
        detailListFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        detaillist_RV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        List<DeatillistClass> list = new ArrayList<>();

        list.add(new DeatillistClass("Adisha Tiffin Service", "Biryani,Lunchbox,Kebab,Mughlai", "\t&#8377; 200  for one", "10-20 min", R.drawable.tiffin));
        list.add(new DeatillistClass("Gavran Poli Bhaji Kendra", "Poli,Bhaji,Dal-Rice,Lunchbox", "\t&#8377; 250 for one ", "10-20 min", R.drawable.polibhaji));
        list.add(new DeatillistClass("Aaba Cha Dhaba", "Biryani,Lunchbox,Kebab,Mughlai", "\t&#8377; 300 for one ", "20-30 min", R.drawable.aaba));
        list.add(new DeatillistClass("Zunka BHakri Special", "Zunka ,Bhakri,Varan ,Bhat", "\t&#8377; 150 for one ", "15-20 min", R.drawable.zunkabhakri));
        list.add(new DeatillistClass("South Indian Food Kendra", "Idli,Mendu-vada,Dosa,Uttapa,etc.", "\t&#8377; 100 for one ", "10-15 min", R.drawable.southindian));
        list.add(new DeatillistClass("Aai's Bhojnalay", "Chapati,Bhakri,Bhaji,Dal,Rice,Chutney,Papad,Chaas", "\t&#8377; 200 for one ", "10-20 min", R.drawable.bhojnalay));
        list.add(new DeatillistClass("Anna's Lunch katta", "Biryani,Lunchbox,Kebab,Mughlai", "\t&#8377; 200 for one ", "10-20 min", R.drawable.nonveg));
        list.add(new DeatillistClass("Softhub Khanaval", "Biryani,Lunchbox,Kebab,Mughlai", "\t&#8377; 200 for one ", "10-20 min", R.drawable.khanaval));
        list.add(new DeatillistClass("Vanita Lunch Home", "Biryani,Lunchbox,Kebab,Mughlai", "\t&#8377; 200 for one ", "10-20 min", R.drawable.lunch));
        detaillist_RV.setAdapter(new DetailListAdapter(getContext(), list));

        return view;
    }
}
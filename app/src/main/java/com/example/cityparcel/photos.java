package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class photos extends Fragment {
    RecyclerView rv_photolist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_photos, container, false);
        rv_photolist = view.findViewById(R.id.rv_photolist);

        rv_photolist.setLayoutManager(new GridLayoutManager(getContext(),3));
        List<Photoclass> list = new ArrayList<>();


        list.add(new Photoclass(R.drawable.pizza));
        list.add(new Photoclass(R.drawable.food1));
        list.add(new Photoclass(R.drawable.food2));
        list.add(new Photoclass(R.drawable.food3));
        list.add(new Photoclass(R.drawable.fish));
        list.add(new Photoclass(R.drawable.food4));
        list.add(new Photoclass(R.drawable.food5));
        list.add(new Photoclass(R.drawable.food6));
        list.add(new Photoclass(R.drawable.food7));
        list.add(new Photoclass(R.drawable.food8));
        list.add(new Photoclass(R.drawable.food9));



        rv_photolist.setAdapter(new PhotoclassAdapter(getContext(),list));



        return view;
    }
}
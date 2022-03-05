package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Home_fragment extends Fragment {
    RecyclerView restolist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        restolist = view.findViewById(R.id.restolist);
        restolist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        List<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant("title 1","description 1","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 2","description 2","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 3","description 3","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 4","description 4","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 5","description 5","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 6","description 6","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 7","description 7","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 8","description 8","10",4.5,R.drawable.birthandanniversary));
        list.add(new Restaurant("title 9","description 9","10",4.5,R.drawable.birthandanniversary));
        restolist.setAdapter(new RestoListAdapter(getContext(),list ));
        // Inflate the layout for this fragment
        return view;


    }
}
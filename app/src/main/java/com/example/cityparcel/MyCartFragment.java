package com.example.cityparcel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyCartFragment extends Fragment {

    RecyclerView rv_carlist;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mycart,container,false);
        rv_carlist = view.findViewById(R.id.rv_carlist);
        rv_carlist.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_carlist.setAdapter(new CartListAdapter(getContext()));

        return view;
    }
}

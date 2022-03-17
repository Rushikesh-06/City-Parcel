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

public class menu extends Fragment {

    RecyclerView menulist_rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_menu, container, false);
        menulist_rv = view.findViewById(R.id.menulist_rv);

        menulist_rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        List<Menulistclass> list = new ArrayList<>();
        list.add(new Menulistclass("Paneer Masala","Rs.200","Paneer,prepared in tomato,with Spices",R.drawable.paneertikka));
        list.add(new Menulistclass("Delux Vegetarian Thali","Rs.200","Dal+sabji+3Roti+Salad+papad+Rice",R.drawable.lunch));
        list.add(new Menulistclass("Mughlai Paneer","Rs.250","Paneer+tomatoes in rich white gravy ",R.drawable.mughlaipaneer));
        list.add(new Menulistclass("Aloo  Matar","Rs.120","Carrots+Beans+paneer+potatoes+capsicum",R.drawable.aloomatar));

        menulist_rv.setAdapter(new Menulist_adapter(getContext(),list));

        return view;
    }
}
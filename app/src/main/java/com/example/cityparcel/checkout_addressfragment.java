package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class checkout_addressfragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        BaseActivity activity = (BaseActivity)getActivity();
        activity.location.setText("Checkout");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout_addressfragment, container, false);
    }
}
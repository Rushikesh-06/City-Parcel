package com.example.cityparcel;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class fragment1 extends Fragment {

    Button next,test;
    TextView skip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        next = view.findViewById(R.id.next);
        test = view.findViewById(R.id.test);
        skip = view.findViewById(R.id.skip_fragment);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (  (PagerActivity) getActivity()).pager.setCurrentItem(1);

            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotonext_fragment = new Intent(getActivity(),LogIn_activity.class);
                startActivity(gotonext_fragment);
                getActivity().finish();
            }
        });

        //test btn
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(getActivity(),BroadcastReceiver_activity.class);
                startActivity(test);
                getActivity().finish();
            }
        });


        return view;
    }
}
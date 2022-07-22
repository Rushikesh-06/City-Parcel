package com.example.cityparcel;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class checkout_addressfragment extends Fragment {

    Button goto_payment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout_addressfragment, container, false);

        goto_payment = view.findViewById(R.id.goto_payment);

        goto_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.addressframe, Paymentfragment.class, null)
                        .commit();*/

                startActivity(new Intent(getActivity(),PaymentActivity.class));
            }
        });

        return view;

    }
}
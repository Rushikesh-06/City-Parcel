package com.example.cityparcel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.CheckoutActivity;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;


public class Paymentfragment extends Fragment implements PaymentResultListener {

    Button paynow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paymentfragment, container, false);

        paynow = view.findViewById(R.id.paynow);

        String samount = "900";
        int amount = Math.round(Float.parseFloat(samount));


        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startpayment();

                /*Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_rwkjf8t5SY7ruf");
                checkout.setImage(R.drawable.alpha);

                JSONObject object = new JSONObject();
                try {
                    object.put("name","City Parcel");
                    object.put("Description","Payment");
                    object.put("theme.color","#0093DD");
                    object.put("currency","INR");
                    object.put("amount",amount);
                    object.put("prefill.contact","9833045917");
                    object.put("prefill.email","Cityparcel@gmail.com");
                    checkout.open(getActivity(),object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }
        });


        return view;
    }

    private void startpayment() {


            final checkout_activity activity =(checkout_activity) getActivity();

            final Checkout co = new Checkout();

            try {
                JSONObject options = new JSONObject();
                options.put("name", "Razorpay Corp");
                options.put("description", "Demoing Charges");
                options.put("send_sms_hash",true);
                options.put("allow_rotation", true);
                //You can omit the image option to fetch the image from dashboard
                options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                options.put("currency", "INR");
                options.put("amount", "100");

                JSONObject preFill = new JSONObject();
                preFill.put("email", "test@razorpay.com");
                preFill.put("contact", "9876543210");

                options.put("prefill", preFill);

                co.open(activity, options);
            } catch (Exception e) {
                Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                        .show();
                e.printStackTrace();
            }

    }

    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Payment Id");
        builder.setMessage(s);
        builder.show();
        
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        
    }
}
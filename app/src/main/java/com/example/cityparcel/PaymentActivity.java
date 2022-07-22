package com.example.cityparcel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {
    Button paynow;
    String samount = "900";
    int amount = Math.round(Float.parseFloat(samount));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        paynow = findViewById(R.id.paynow);




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
                    options.put("send_sms_hash", true);
            options.put("allow_rotation", true);
                    object.put("amount",amount);
                    object.put("prefill.contact","9833045917");
                    object.put("prefill.email","Cityparcel@gmail.com");
                    checkout.open(getActivity(),object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }
        });

    }

    private void startpayment() {


        final PaymentActivity activity = PaymentActivity.this;

        final Checkout co = new Checkout();

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Razorpay Corp");
            options.put("description", "Demoing Charges");
            options.put("send_sms_hash", true);
            options.put("allow_rotation", true);
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount",amount);

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
        AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
        builder.setTitle("Payment Id");
        builder.setMessage(s);
        builder.show();

        startActivity(new Intent(PaymentActivity.this,BaseActivity.class));
        finish();
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(PaymentActivity.this, s, Toast.LENGTH_SHORT).show();

    }
}

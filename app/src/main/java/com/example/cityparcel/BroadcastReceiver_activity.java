package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class BroadcastReceiver_activity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 0;
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static BroadcastReceiver_activity instance;
    TextView phoneNo, message_tv;
    private String TAG = getClass().getSimpleName();


    MyReceiver receiver = new MyReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            BroadcastReceiver_activity.this.phoneNo.setText(phoneNo);
//            BroadcastReceiver_activity.this.message_tv.setText(msg);
        }
    };


    public static BroadcastReceiver_activity getInstance() {
        return instance;
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver,new IntentFilter(SMS_RECEIVED));
        instance = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        phoneNo = findViewById(R.id.phone_number);
        message_tv = findViewById(R.id.message);

//        message.setText(MyReceiver.msg);
//        phoneNo.setText(MyReceiver.phoneNo);

        if (ContextCompat.checkSelfPermission(BroadcastReceiver_activity.this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(BroadcastReceiver_activity.this, Manifest.permission.RECEIVE_SMS)) {
                Toast.makeText(this, "You Have Denied The SMS Permission", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(BroadcastReceiver_activity.this, new String[]{Manifest.permission.RECEIVE_SMS}, MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
            }
        }





        LocalBroadcastManager.getInstance(BroadcastReceiver_activity.this).registerReceiver(new MyReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e(TAG, "onReceive:  tteygjgyyg" );
            }
        }, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECEIVE_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Please Give Permission For SMS", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    public void setSMStext(String number,String message){
        phoneNo.setText(number);
        message_tv.setText(message);
    }

  /*  @Override
    public void OnMessageReceived(HashMap<String, String> map) {
        String msg = map.get("msg");
        String phoneNo = map.get("phoneNo");
        Log.e(TAG, "OnMessageReceived: " + msg);
        Log.e(TAG, "OnMessageReceived: " + phoneNo);

    }*/
}
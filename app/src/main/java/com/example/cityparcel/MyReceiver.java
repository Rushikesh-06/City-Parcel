package com.example.cityparcel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MyReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SmsBroadcastReceiver";
     public static String msg,phoneNo = "";
//    MessageReceiveListner messageReceiveListner;

  /*  public MyReceiver(MessageReceiveListner messageReceiveListner) {
        this.messageReceiveListner = messageReceiveListner;
    }*/

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e(TAG, "Intent Received: " + intent.getAction());
        if (intent.getAction() == SMS_RECEIVED) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdu = (Object[]) bundle.get("pdus");
                final SmsMessage[] message = new SmsMessage[pdu.length];

                for (int i = 0; i < pdu.length; i++) {
                    if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                        String format = bundle.getString("format");
                        message[i] =  SmsMessage.createFromPdu((byte[])pdu[i],format);
                    }
                    else{
//                        < apilevel 23
                        message[i] =  SmsMessage.createFromPdu((byte[])pdu[i]);
                    }

                    msg =  message[i].getMessageBody();
                    phoneNo = message[i].getOriginatingAddress();


//                    messageReceiveListner.OnMessageReceived(messagemap);

                }
                Toast.makeText(context, "Message"+ msg +"\nNumber: "+phoneNo, Toast.LENGTH_SHORT).show();
                BroadcastReceiver_activity activity = BroadcastReceiver_activity.getInstance();
                activity.setSMStext(phoneNo,msg);

            }
        }

    }
}
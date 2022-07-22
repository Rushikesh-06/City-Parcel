package com.example.cityparcel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class birthdate_anniversarydate extends AppCompatActivity {
    TextView birthdate, anniversarydate;
    private String TAG = getClass().getSimpleName();
    Button submit_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdate_anniversarydate);
        birthdate = findViewById(R.id.birthdate);
        anniversarydate = findViewById(R.id.anniversarydate);
        submit_date = findViewById(R.id.submit_date);

        birthdate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                Calendar minage = Calendar.getInstance();
                minage.add(Calendar.YEAR,-18);
                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(birthdate_anniversarydate.this);
                datePickerDialog.getDatePicker().setMaxDate(minage.getTimeInMillis());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int exactmonth = month + 1;
                        birthdate.setText(year + "-" + (exactmonth) + "-" + dayOfMonth);
                        Log.e(TAG, "onDateSet: " + birthdate);
                    }
                });
                datePickerDialog.show();
            }
        });


        anniversarydate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(birthdate_anniversarydate.this);
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int exactmonth = month + 1;
                        anniversarydate.setText(year + "-" + (exactmonth) + "-" + dayOfMonth);
                        Log.e(TAG, "onDateSet: " + anniversarydate);
                    }
                });
                datePickerDialog.show();
            }
        });

        submit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences preferences = getSharedPreferences("CityParcel", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Birthdate",birthdate.getText().toString());
                editor.putString("AnniversaryDate",anniversarydate.getText().toString());
                editor.commit();

                startActivity(new Intent(birthdate_anniversarydate.this,BaseActivity.class) );
                finish();

            }
        });

    }
}
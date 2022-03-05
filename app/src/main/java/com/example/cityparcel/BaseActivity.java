package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {
    NonSwipableViewPager BaseActivity_Pager;
    Menu menu;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


         BaseActivity_Pager = findViewById(R.id.baseactivity_pager);

         BaseActivityAdapter basepageradapter = new com.example.cityparcel.BaseActivityAdapter(getSupportFragmentManager());
         BaseActivity_Pager.setAdapter(basepageradapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.base_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
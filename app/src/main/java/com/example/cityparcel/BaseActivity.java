package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class BaseActivity extends AppCompatActivity{
    NonSwipableViewPager BaseActivity_Pager;
    Menu menu;
    public Toolbar toolbar;
    public TextView location;
    TabLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        toolbar = findViewById(R.id.toolbar);
        tab = findViewById(R.id.tab);
        BaseActivity_Pager = findViewById(R.id.baseactivity_pager);
        location = findViewById(R.id.location);


        setSupportActionBar(toolbar);

        BaseActivityAdapter basepageradapter = new com.example.cityparcel.BaseActivityAdapter(getSupportFragmentManager());
        BaseActivity_Pager.setAdapter(basepageradapter);


     /*   favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true)
                    favorite.setImageResource(R.drawable.ic_baseline_favorite_red);
            }
        });*/


        //tab layout icon set
        tab.setupWithViewPager(BaseActivity_Pager);
        for (int i = 0; i < tab.getTabCount(); i++) {
            switch (i) {
                case 0:
                    tab.getTabAt(i).setIcon(R.drawable.ic_baseline_home_orange);
                    break;
                case 1:
                    tab.getTabAt(i).setIcon(R.drawable.ic_baseline_shopping_cart_24);
                    break;
                case 2:
                    tab.getTabAt(i).setIcon(R.drawable.ic_baseline_brunch_dining);
                    break;
                case 3:
                    tab.getTabAt(i).setIcon(R.drawable.ic_baseline_person);
                    break;
            }
        }

        //color change icon on selected pager
        BaseActivity_Pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0; i<tab.getTabCount(); i++){

                    switch (i){
                        case 0:
                            if (position == 0){
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_home_orange);

                            }else
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_home_24);
                            break;
                        case 1:
                            if (position == 1){
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_shopping_cart_orange);
                            }else
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_shopping_cart_24);
                            break;
                            case 2:
                            if (position == 2){
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_brunch_dining_orange);
                            }else
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_brunch_dining);
                            break;
                            case 3:
                            if (position == 3){
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_person_orange);
                            }else
                                tab.getTabAt(i).setIcon(R.drawable.ic_baseline_person);
                            break;

                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    //menu create for search and notification icon in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.base_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    //back press condition when new fragment overlap
    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.homeframe);
        if (fragment != null) {
            if (fragment instanceof DeatilList_fragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
            if (fragment instanceof restolist_fragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }

            if (fragment instanceof Framlist_fragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
            if (fragment instanceof Giftlist_fragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }if (fragment instanceof RestaurantDetails) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }

        }
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BaseActivity.this).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setMessage("Are you want to close this View?");
        alertDialog.create();
        alertDialog.show();
    }
}
package com.example.cityparcel;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;


public class review extends Fragment {

    RecyclerView rv_review;
    Button addreview,btn_submit;
    CardView cardview_bsreview;
    RatingBar ratingbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view =  inflater.inflate(R.layout.fragment_review, container, false);
        rv_review = view.findViewById(R.id.rv_review);
        addreview = view.findViewById(R.id.addreview);
        cardview_bsreview = view.findViewById(R.id.cardview_bsreview);
        btn_submit = view.findViewById(R.id.btn_submit);
        ratingbar = view.findViewById(R.id.ratingbar_review);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(cardview_bsreview);
                bottomSheetBehavior.setState(bottomSheetBehavior.STATE_HIDDEN);
            }
        });


        rv_review.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        List<ReviewClass> list = new ArrayList<>();
        list.add(new ReviewClass("Pankaj Jadhav","Food is really amazing.","Superb food and hospitality.Had a lovely time.","All the environment is really very deligtfull and","live orchestra was most entertaining.",R.drawable.pankajjadhav));
        list.add(new ReviewClass("Rushikesh Shingan","Amazing Experience","Excellent Food taste and refreshing drinks","and also Staff is very humble","",R.drawable.rushi));
        list.add(new ReviewClass("Pruthvi","Food is really amazing.","Good food and environment","Amazing experience","",R.drawable.pruthvi));
        rv_review.setAdapter(new ReviewAdapter(getContext(),list));


        addreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View botttomshetview = view.findViewById(R.id.review_btmsheet);
                botttomshetview.setVisibility(View.VISIBLE);
            }
        });





        return view;
    }
}
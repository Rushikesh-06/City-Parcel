package com.example.cityparcel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    Context context;
    List<ReviewClass> list;

    public ReviewAdapter(Context context, List<ReviewClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review_row,parent,false);
        ReviewHolder reviewHolder = new ReviewHolder(view);
        return reviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        ReviewClass reviewClass = list.get(position);
        holder.review_username.setText(reviewClass.getUsername());
        holder.reviewheading.setText(reviewClass.getReviewheading());
        holder.reviewdesc_line1.setText(reviewClass.getReviewdesc_line1());
        holder.reviewdesc_line2.setText(reviewClass.getReviewdesc_line2());
        holder.reviewdesc_line3.setText(reviewClass.getReviewdesc_line3());
        holder.circle_imageview.setImageResource(reviewClass.getUserimage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReviewHolder extends RecyclerView.ViewHolder {

        ImageView circle_imageview;
        TextView reviewheading,reviewdesc_line1,reviewdesc_line2,reviewdesc_line3,review_username;

        public ReviewHolder(@NonNull View itemView) {
            super(itemView);

            review_username = itemView.findViewById(R.id.review_username);
            circle_imageview = itemView.findViewById(R.id.circle_imageview);
            reviewheading = itemView.findViewById(R.id.reviewheading);
            reviewdesc_line1 = itemView.findViewById(R.id.reviewdesc_line1);
            reviewdesc_line2 = itemView.findViewById(R.id.reviewdesc_line2);
            reviewdesc_line3 = itemView.findViewById(R.id.reviewdesc_line3);


        }
    }
}

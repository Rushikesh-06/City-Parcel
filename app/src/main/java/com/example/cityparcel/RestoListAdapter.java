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

public class RestoListAdapter extends RecyclerView.Adapter<RestoListAdapter.MyViewHolder> {
    Context context;
    List<Restaurant> list;

    public RestoListAdapter(Context context, List<Restaurant> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Restaurant restaurant = list.get(position);
        holder.hotelimg.setImageResource(restaurant.getImage());
        holder.title.setText(restaurant.getTitle());
        holder.description.setText(restaurant.getDescription());
        holder.delivery_time.setText(restaurant.getDelivery_time());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelimg;
        TextView title,description,delivery_time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelimg = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            delivery_time = itemView.findViewById(R.id.delivery_time);
        }
    }
}

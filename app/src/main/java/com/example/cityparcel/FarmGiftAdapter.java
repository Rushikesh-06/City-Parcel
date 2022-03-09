package com.example.cityparcel;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FarmGiftAdapter extends RecyclerView.Adapter<FarmGiftAdapter.CustomviewHolder> {

    Context context;
    List<FarmGiftClass> list;

    public FarmGiftAdapter(Context context, List<FarmGiftClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.farm_gift,parent,false);
        return new CustomviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomviewHolder holder, int position) {

        FarmGiftClass farmGiftClass = list.get(position);
        holder.image.setImageResource(farmGiftClass.getImage());
        holder.title.setText(farmGiftClass.getTitle());
        holder.price.setText(Html.fromHtml(farmGiftClass.getPrice()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomviewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,price;
        public CustomviewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);

        }
    }
}

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

public class Detaillist_framgiftadapter extends RecyclerView.Adapter<Detaillist_framgiftadapter.CustomviewHolder> {
    Context context;
    List<DetaillistFarmGift_class> list;

    public Detaillist_framgiftadapter(Context context, List<DetaillistFarmGift_class> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public CustomviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detaillist_farmgift,parent,false);
        return new CustomviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomviewHolder holder, int position) {

        DetaillistFarmGift_class detaillistFarmGift_class = list.get(position);
        holder.title.setText(detaillistFarmGift_class.getTitle());
        holder.price.setText(Html.fromHtml(detaillistFarmGift_class.getPrice()));
        holder.image.setImageResource(detaillistFarmGift_class.getImage());

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

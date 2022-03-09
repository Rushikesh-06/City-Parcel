package com.example.cityparcel;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.CustomviewHolder> {
    Context context;
    List<DeatillistClass> list;

    public DetailListAdapter(Context context, List<DeatillistClass> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public CustomviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View     view = LayoutInflater.from(context).inflate(R.layout.detail_list,parent,false);
        return new CustomviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomviewHolder holder, int position) {
        DeatillistClass detaillist = list.get(position);
        holder.title.setText(detaillist.getTitle());
        holder.description.setText(detaillist.getDescription());
        holder.price.setText(Html.fromHtml(detaillist.getPrice()));
        holder.deliverytime.setText(detaillist.getDelivery_time());
        holder.image.setImageResource(detaillist.getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomviewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,price,description,deliverytime;


        public CustomviewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.IV_detaillist);
            title = itemView.findViewById(R.id.hotel_title);
            description = itemView.findViewById(R.id.hotel_description);
            price = itemView.findViewById(R.id.price);
            deliverytime = itemView.findViewById(R.id.delivery_time);

        }
    }
}

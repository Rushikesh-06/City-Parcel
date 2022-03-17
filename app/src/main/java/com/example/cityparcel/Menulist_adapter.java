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

public class Menulist_adapter extends RecyclerView.Adapter<Menulist_adapter.CustomviewHolder> {

    Context context;
    List<Menulistclass> list;

    public Menulist_adapter(Context context, List<Menulistclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.menucard_row,parent,false);
        return new CustomviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomviewHolder holder, int position) {

        Menulistclass menulistclass = list.get(position);
        holder.dishtitle.setText(menulistclass.getDishname());
        holder.dish_description.setText(menulistclass.getDescription());
        holder.price.setText(menulistclass.getPrice());
        holder.iv_image.setImageResource(menulistclass.getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomviewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;
        TextView dishtitle,dish_description,price;

        public CustomviewHolder(@NonNull View itemView) {
            super(itemView);

            dish_description = itemView.findViewById(R.id.dish_description);
            iv_image = itemView.findViewById(R.id.iv_image);
            dishtitle = itemView.findViewById(R.id.dishtitle);
            price = itemView.findViewById(R.id.price);

        }
    }
}

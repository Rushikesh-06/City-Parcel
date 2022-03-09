package com.example.cityparcel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScrollimageAdapter extends RecyclerView.Adapter<ScrollimageAdapter.ViewHolder> {

    Context context;
    List<Integer> scrollimage_list;

    public ScrollimageAdapter(Context context, List<Integer> scrollimage_list) {
        this.context = context;
        this.scrollimage_list = scrollimage_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(context).inflate(R.layout.scroll_image_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Scroll_image.setImageResource(scrollimage_list.get(position));
    }

    @Override
    public int getItemCount() {
        return scrollimage_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Scroll_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Scroll_image =  itemView.findViewById(R.id.Scroll_imageID);


        }
    }
}

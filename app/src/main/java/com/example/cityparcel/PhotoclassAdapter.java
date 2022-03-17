package com.example.cityparcel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoclassAdapter extends RecyclerView.Adapter<PhotoclassAdapter.Imageholder> {

    Context context;
    List<Photoclass> list;

    public PhotoclassAdapter(Context context, List<Photoclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Imageholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photolist_row,parent,false);
        Imageholder imageholder = new Imageholder(view);
        return imageholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Imageholder holder, int position) {
        Photoclass photoclass = list.get(position);
        holder.photolist_row.setImageResource(photoclass.getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Imageholder extends RecyclerView.ViewHolder {
        ImageView photolist_row;
        public Imageholder(@NonNull View itemView) {
            super(itemView);

            photolist_row = itemView.findViewById(R.id.photolist_row);
        }
    }
}

package com.fcfas.musikjaksel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fcfas.musikjaksel.R;
import com.fcfas.musikjaksel.model.Indie;

import java.util.ArrayList;

public class GridIndieAdapter extends RecyclerView.Adapter<GridIndieAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Indie> listIndie;

    public ArrayList<Indie> getListIndie() {
        return listIndie;
    }

    public void setListIndie(ArrayList<Indie> listIndie) {
        this.listIndie = listIndie;
    }

    public GridIndieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_indie, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListIndie().get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListIndie().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
package com.fcfas.musikjaksel.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fcfas.musikjaksel.R;
import com.fcfas.musikjaksel.model.Indie;

import java.util.ArrayList;

public class ListIndieAdapter extends
        RecyclerView.Adapter<ListIndieAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<Indie> listIndie;

    public ListIndieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Indie> getListIndie() {
        return listIndie;
    }

    public void setListIndie(ArrayList<Indie> listIndie) {
        this.listIndie = listIndie;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_indie, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListIndie().get(position).getName());
        categoryViewHolder.tvCategory.setText(getListIndie().get(position).getName());

        Glide.with(context)
                .load(getListIndie().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListIndie().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCategory;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCategory = itemView.findViewById(R.id.tv_item_category);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
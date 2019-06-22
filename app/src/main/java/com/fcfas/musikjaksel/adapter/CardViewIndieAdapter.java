package com.fcfas.musikjaksel.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fcfas.musikjaksel.DetailIndieActivity;
import com.fcfas.musikjaksel.R;
import com.fcfas.musikjaksel.model.Indie;

import java.util.ArrayList;

public class CardViewIndieAdapter extends RecyclerView.Adapter<CardViewIndieAdapter.CardViewViewHolder> {

    private ArrayList<Indie> listIndie;
    private Context context;
    private Activity activity;

    public ArrayList<Indie> getListIndie() {
        return listIndie;
    }

    public void setListIndie(ArrayList<Indie> listIndie) {
        this.listIndie = listIndie;
    }

    public CardViewIndieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_indie, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Indie indie = listIndie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(indie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(indie.getName());
        holder.tvCategory.setText(indie.getCategory());
        holder.indie = indie;

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " +
                        listIndie.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listIndie.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgPhoto;
        TextView tvName, tvCategory;
        Button btnFavorite, btnDetail;
        Indie indie;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCategory = itemView.findViewById(R.id.tv_item_category);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnDetail = itemView.findViewById(R.id.btn_set_share);
            btnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailIndieActivity.class);
            context.startActivity(intent);
        }
    }
}

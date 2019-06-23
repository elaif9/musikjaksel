package com.fcfas.musikjaksel.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
import com.fcfas.musikjaksel.helper.CustomOnItemClickListener;
import com.fcfas.musikjaksel.model.Indie;

import java.util.ArrayList;

public class CardViewIndieAdapter extends RecyclerView.Adapter<CardViewIndieAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Indie> listIndie;
    private ArrayList<Indie> getListResep(){
        return listIndie;
    }
    public void setListIndie(ArrayList<Indie> listIndie){
        this.listIndie = listIndie;
    }
    public CardViewIndieAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewIndieAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_indie, viewGroup,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewIndieAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        final Indie r = getListResep().get(i);

        Glide.with(context)
                .load(r.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(r.getName());
        cardViewViewHolder.tvCategory.setText(r.getCategory());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " +getListResep().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " +getListResep().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }



    @Override
    public int getItemCount() {
        return getListResep().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvCategory;
        Button btnFavorite, btnShare;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCategory = itemView.findViewById(R.id.tv_item_category);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_detail);
        }
    }
}

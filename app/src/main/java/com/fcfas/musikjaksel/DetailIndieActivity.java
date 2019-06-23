package com.fcfas.musikjaksel;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fcfas.musikjaksel.adapter.CardViewIndieAdapter;
import com.fcfas.musikjaksel.adapter.GridIndieAdapter;
import com.fcfas.musikjaksel.adapter.ListIndieAdapter;
import com.fcfas.musikjaksel.helper.ItemClickSupport;
import com.fcfas.musikjaksel.model.Indie;
import com.fcfas.musikjaksel.model.IndieData;

import java.net.URI;
import java.util.ArrayList;

public class DetailIndieActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_CATEGORY = "extra_category";
    public static final String EXTRA_REMARKS = "extra_remarks";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_LINK = "extra_detail";

    TextView tvNama, tvCategory, tvRemarks;
    Button btnYoutube;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_indie);

        tvNama =  findViewById(R.id.tv_item_name);
        tvCategory = findViewById(R.id.tv_item_category);
        tvRemarks = findViewById(R.id.tv_item_remarks);
        imgPhoto = findViewById(R.id.img_item_photo);
        btnYoutube = findViewById(R.id.btn_set_youtube);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        String remark = getIntent().getStringExtra(EXTRA_REMARKS);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        final String link = getIntent().getStringExtra(EXTRA_LINK);

        tvNama.setText(name);
        tvCategory.setText(category);
        tvRemarks.setText(remark);
        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions().override(300,300))
                .into(imgPhoto);

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intentYoutube);
            }
        });
    }
}

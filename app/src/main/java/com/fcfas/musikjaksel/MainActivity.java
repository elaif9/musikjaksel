package com.fcfas.musikjaksel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fcfas.musikjaksel.adapter.ListIndieAdapter;
import com.fcfas.musikjaksel.model.Indie;
import com.fcfas.musikjaksel.model.IndieData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Indie> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(IndieData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListIndieAdapter listIndieAdapter = new ListIndieAdapter(this);
        listIndieAdapter.setListIndie(list);
        rvCategory.setAdapter(listIndieAdapter);
    }
}

package com.fcfas.musikjaksel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.fcfas.musikjaksel.adapter.CardViewIndieAdapter;
import com.fcfas.musikjaksel.adapter.GridIndieAdapter;
import com.fcfas.musikjaksel.adapter.ListIndieAdapter;
import com.fcfas.musikjaksel.model.Indie;
import com.fcfas.musikjaksel.model.IndieData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Indie> list = new ArrayList<>();
    private String title = "Music Jaksel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(IndieData.getListData());
        setActionBarTitle("Music Jaksel");
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListIndieAdapter listIndieAdapter = new ListIndieAdapter(this);
        listIndieAdapter.setListIndie(list);
        rvCategory.setAdapter(listIndieAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode) {
            case R.id.action_list:
                title = "Music Jaksel";
                showRecyclerList();
                break;
            case R.id.action_gallery:
                title = "Music Gallery";
                showRecyclerGrid();
                break;
            case R.id.action_story:
                title = "Story Music";
                showRecyclerCardView();
                break;
        }
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridIndieAdapter gridIndieAdapter = new GridIndieAdapter(list);
        rvCategory.setAdapter(gridIndieAdapter);
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewIndieAdapter cardViewIndieAdapter = new CardViewIndieAdapter(this);
        cardViewIndieAdapter.setListIndie(list);
        rvCategory.setAdapter(cardViewIndieAdapter);
    }
}

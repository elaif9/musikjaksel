package com.fcfas.musikjaksel;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fcfas.musikjaksel.adapter.CardViewIndieAdapter;
import com.fcfas.musikjaksel.adapter.GridIndieAdapter;
import com.fcfas.musikjaksel.adapter.ListIndieAdapter;
import com.fcfas.musikjaksel.helper.ItemClickSupport;
import com.fcfas.musikjaksel.model.Indie;
import com.fcfas.musikjaksel.model.IndieData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Indie> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if(savedInstanceState == null){
            setActionBarTitle("Music Jaksel");
            list.addAll(IndieData.getListData());
            showRecyclerList();
            mode =  R.id.action_list;
        }else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Indie> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedResep(Indie indie){
        Intent intent = new Intent(MainActivity.this,DetailIndieActivity.class );
        intent.putExtra(DetailIndieActivity.EXTRA_NAME, indie.getName());
        intent.putExtra(DetailIndieActivity.EXTRA_CATEGORY, indie.getCategory());
        intent.putExtra(DetailIndieActivity.EXTRA_REMARKS, indie.getRemarks());
        intent.putExtra(DetailIndieActivity.EXTRA_PHOTO, indie.getPhoto());
        intent.putExtra(DetailIndieActivity.EXTRA_LINK, indie.getLinkcontent());
        startActivity(intent);
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewIndieAdapter cardViewResepAdapter = new CardViewIndieAdapter(this);
        cardViewResepAdapter.setListIndie(list);
        rvCategory.setAdapter(cardViewResepAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedResep(list.get(position));
            }
        });
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListIndieAdapter listResepAdapter = new ListIndieAdapter(this);
        listResepAdapter.setListIndie(list);
        rvCategory.setAdapter(listResepAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedResep(list.get(position));
            }
        });
    }

    private  void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridIndieAdapter gridResepAdapter = new GridIndieAdapter(this);
        gridResepAdapter.setListIndie(list);
        rvCategory.setAdapter(gridResepAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedResep(list.get(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_story:
                title = "They Story";
                showRecyclerCardView();
                break;

            case R.id.action_gallery:
                title = "Music Gallery";
                showRecyclerGrid();
                break;

            case R.id.action_list:
                title = "Music Gallery";
                showRecyclerList();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }


}

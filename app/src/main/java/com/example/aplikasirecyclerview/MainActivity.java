package com.example.aplikasirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    ArrayList<Karakter> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        data = new ArrayList<>();
        for (int i = 0; i < ItemKarakter.Headline.length; i++) {
            data.add(new Karakter(
                    ItemKarakter.Headline[i],
                    ItemKarakter.Subhead[i],
                    ItemKarakter.iconList[i]
            ));
        }

        showList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_list) {
            showList();
        } else if (item.getItemId() == R.id.menu_grid) {
            showGrid();
        }
        return true;
    }

    private void showList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        AdapterList adapterList = new AdapterList(data);
        recyclerView.setAdapter(adapterList);
    }

    private void showGrid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        AdapterGrid adapterGrid = new AdapterGrid(data);
        recyclerView.setAdapter(adapterGrid);
    }
}
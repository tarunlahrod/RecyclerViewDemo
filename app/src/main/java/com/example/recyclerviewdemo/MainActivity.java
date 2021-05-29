package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_addOne;
    Menu menu;

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<President> presidentList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList = myApplication.getPresidentList();

        Log.i("check", "onCreate: " + presidentList.toString());
//        Toast.makeText(this, "List length: " + presidentList.size(), Toast.LENGTH_SHORT).show();

        btn_addOne = findViewById(R.id.btn_addOne);
        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.lv_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(presidentList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menue_aToZ:
                // sort a to z
                Collections.sort(presidentList, President.PresidentNameAZComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_zToa:
                // sort z to a
                Collections.sort(presidentList, President.PresidentNameZAComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_dataAcending:
                // sort date ascending
                Collections.sort(presidentList, President.PresidentDateAscendingComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_dateDescending:
                // sort date descending
                Collections.sort(presidentList, President.PresidentDateDescendingComparator);
                mAdapter.notifyDataSetChanged();
                return true;
        }
        return true;
    }
}
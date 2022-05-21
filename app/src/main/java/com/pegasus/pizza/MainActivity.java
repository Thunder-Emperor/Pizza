package com.pegasus.pizza;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private customeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        WindowCompat.setDecorFitsSystemWindows(getWindow(),false);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //grid layout for foods icon
        LinearLayoutManager horizontal_Layout = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        ArrayList<Integer> foods = new ArrayList<>();
        foods.add(R.drawable.cheese);
        foods.add(R.drawable.coffee);
        foods.add(R.drawable.bowl);
        foods.add(R.drawable.brezel);
        foods.add(R.drawable.noodleses);
        foods.add(R.drawable.taps);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(horizontal_Layout);
        adapter = new customeAdapter(this, foods);
        recyclerView.setAdapter(adapter);
    }
    // menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this,Order_Activity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItemId(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

}
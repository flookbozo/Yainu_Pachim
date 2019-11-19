package com.example.yainu_pachim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.yainu_pachim.adapter.RecyclerViewAdapter;
import com.example.yainu_pachim.model.Menu;
import com.example.yainu_pachim.room.AppDatabase;
import com.example.yainu_pachim.room.MenuRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button maleButton = findViewById(R.id.male_button);
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculatorCaloryActivity.class);
                intent.putExtra("sex",0);
                startActivity(intent);
            }
        });

        Button femaleButton = findViewById(R.id.female_button);
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculatorCaloryActivity.class);
                intent.putExtra("sex",1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        relodeData();
    }

    private void relodeData() {
        MenuRepository repo = new MenuRepository(MainActivity.this);

        repo.getMenu(new MenuRepository.Callback() {
            @Override
            public void onGet(List<Menu> itemList) {

                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                        MainActivity.this,
                        R.layout.menu,
                        itemList
                );
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });
    }
}

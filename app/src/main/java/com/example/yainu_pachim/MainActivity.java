package com.example.yainu_pachim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.yainu_pachim.adapter.RecyclerViewAdapter;
import com.example.yainu_pachim.model.Menu;
import com.example.yainu_pachim.room.MenuRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuRepository repo = new MenuRepository(MainActivity.this);

        repo.getMenu(new MenuRepository.Callback() {
            @Override
            public void onGetLedger(List<Menu> itemList) {

                CheckBox calbox = findViewById(R.id.cal_button);
                int totalcal = 0;
                for (Menu item : itemList) {
                    if (calbox.isChecked()) {
                        totalcal += item.cal;
                    }
                }
                Intent intent = new Intent(MainActivity.this,CalculatorCaloryActivity.class);
                intent.putExtra("totalcal", totalcal);
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

        Button enterButton = findViewById(R.id.enterbutton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculatorCaloryActivity.class);
                startActivity(intent);
            }
        });
        //relodeData();
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        relodeData();
    }

    private void relodeData() {
        MenuRepository repo = new MenuRepository(MainActivity.this);

        repo.getMenu(new MenuRepository.Callback() {
            @Override
            public void onGetLedger(List<Menu> itemList) {


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
    }*/
}

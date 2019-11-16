package com.example.yainu_pachim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);

        Intent intent = getIntent();
        String menuname = intent.getStringExtra("name");
        String menutype = intent.getStringExtra("type");
        int menuImageRes = intent.getIntExtra("image",0);
        int menucal = intent.getIntExtra("cal",0);

        ImageView coverImage = findViewById(R.id.cover_image_view);
        coverImage.setImageResource(menuImageRes);

        TextView namecover = findViewById(R.id.name_cover);
        namecover.setText(menuname);

        TextView typecover = findViewById(R.id.type_cover);
        typecover.setText(menutype);

        TextView calcover = findViewById(R.id.cal_cover);
        calcover.setText(String.valueOf(menucal));
    }
}

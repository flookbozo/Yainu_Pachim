package com.example.yainu_pachim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorCaloryActivity extends AppCompatActivity {

    private int mSex;
    private double calperdaymale ;
    private double calperdayfemale ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_calory);

        Intent intent = getIntent();
        mSex = intent.getIntExtra("sex",0);
        
        Button enter = findViewById(R.id.enter_button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ageEditText = findViewById(R.id.age_edit_text);
                int ageEdit = Integer.parseInt(ageEditText.getText().toString());

                EditText weightEditText = findViewById(R.id.weight_edit_text);
                int weightEdit = Integer.parseInt(weightEditText.getText().toString());

                EditText heightEditText = findViewById(R.id.height_edit_text);
                int heightEdit = Integer.parseInt(heightEditText.getText().toString());

                calperdayfemale = ((10*weightEdit)+(6.25*heightEdit)-(5*ageEdit))-161;

                calperdaymale = ((10*weightEdit)+(6.25*heightEdit)-(5*ageEdit))+5;

                TextView TotalCalTextView = findViewById(R.id.total_cal_cover_text_view);
                TotalCalTextView.setText(String.valueOf(mSex == 0? calperdaymale : calperdayfemale).concat( "กิโลแคลอรี่"));

                TextView descripText = findViewById(R.id.descrip_text_view);
                descripText.setText(mSex == 0? "เพียงพอต่อความต้องการในหนึ่งวันของเพศชาย" : "เพียงพอต่อความต้องการในหนึ่งวันของเพศหญิง");
            }
        });

    }
}

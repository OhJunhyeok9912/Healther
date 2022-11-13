package com.example.healtherlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Golden_Six_Input extends AppCompatActivity {

    private EditText input_s,input_wide,input_neck,input_barbell;
    private String strBMI,strWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.golden_six_program_input);

        Intent intent = getIntent();
        strBMI = intent.getStringExtra("BMI");
        strWeight = intent.getStringExtra("Weight");


    }

}

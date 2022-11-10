package com.example.healtherlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Program_home extends AppCompatActivity {

    private Button Recommendation, Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_program_home);
        Intent intent = getIntent();

    }
    public void Caculate(View v) {
        Intent Caculate = new Intent(Program_home.this, Program.class);
        startActivity(Caculate);
    }

    public void Recommendation(View v) {
        Intent Recommendation = new Intent(Program_home.this, Program_Recommendation.class);
        startActivity(Recommendation);
    }


}

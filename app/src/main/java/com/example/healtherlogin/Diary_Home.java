package com.example.healtherlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Diary_Home extends AppCompatActivity {


    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference= firebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_home);

        BottomNavigationView bottom_navi = findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.Diary){
                    Toast.makeText(Diary_Home.this, "현재 화면입니다", Toast.LENGTH_SHORT).show();
                }else if(item.getItemId()==R.id.Calculate){
                    Intent Calculate= new Intent(Diary_Home.this, Program.class);
                    startActivity(Calculate);
                }else if(item.getItemId()==R.id.Recommendation){
                    Intent Recommendation= new Intent(Diary_Home.this, Program_BMI.class);
                    startActivity(Recommendation);
                }

                return false;
            }
        });


    }



}

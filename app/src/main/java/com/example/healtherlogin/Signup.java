package com.example.healtherlogin;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private EditText Email_join;
    private EditText Pwd_join;
    private EditText Age_join,Weight_join,Height_join;
    private Button btn;
    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference= firebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Email_join = (EditText) findViewById(R.id.save_ID);
        Pwd_join = (EditText) findViewById(R.id.save_PW);
        Age_join=(EditText)findViewById(R.id.save_AGE);
        Weight_join=(EditText)findViewById(R.id.save_WEI);
        Height_join=(EditText)findViewById(R.id.save_HEI);
        btn = (Button) findViewById(R.id.signup_but2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String a = Email_join.getText().toString().trim();
                final String b = Pwd_join.getText().toString().trim();
                final String c = Age_join.getText().toString().trim();
                final String d = Weight_join.getText().toString().trim();
                final String e = Height_join.getText().toString().trim();
                //공백인 부분을 제거하고 보여주는 trim();


                firebaseAuth.createUserWithEmailAndPassword(a, b)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    User newuser = new User(user.getEmail(),b,c,d,e);
                                    databaseReference.child("User").child(user.getUid()).child("유저정보").setValue(newuser);
                                    Toast.makeText(Signup.this, "가입 성공", Toast.LENGTH_SHORT).show();
                                    Intent complete = new Intent(Signup.this, MainActivity.class);
                                    startActivity(complete);
                                    finish();

                                } else {
                                    Toast.makeText(Signup.this, "등록 에러", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }

        });


    }


}
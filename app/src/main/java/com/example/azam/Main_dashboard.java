package com.example.azam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_dashboard extends AppCompatActivity {
    Button user,doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        user=findViewById(R.id.userID);
        doctor=findViewById(R.id.doctorID);

        user.setOnClickListener(view -> {
            startActivity(new Intent(Main_dashboard.this, LoginActivity.class));
        });
        doctor.setOnClickListener(view -> {
            startActivity(new Intent(Main_dashboard.this, Doctor_login.class));
        });
    }
}
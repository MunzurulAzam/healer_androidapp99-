package com.example.azam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void Doctor_Pannel(View view){
        startActivity(new Intent(getApplicationContext(),Doctor_Pannel.class));
    }

    public void Profile(View view) {
        startActivity(new Intent(getApplicationContext(),UserProfile.class));
    }
    public void Logout(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
}
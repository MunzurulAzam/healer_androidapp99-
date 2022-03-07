package com.example.azam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Doctor_dasboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_dasboard_activity);

    }
    public void Dprofile(View view) {
        startActivity(new Intent(getApplicationContext(),Doctor_profile.class));
    }
    public void Appointment(View view) {
        startActivity(new Intent(getApplicationContext(),Appointment.class));
    }
    public void Dpateint(View view) {
        startActivity(new Intent(getApplicationContext(),MypatientList.class));
    }
    public void Dlogout(View view) {
        startActivity(new Intent(getApplicationContext(),Doctor_login.class));
        finish();
    }
}
package com.example.azam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Doctor_Pannel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_pannel);
    }

    public void Brain(View view) { startActivity(new Intent(getApplicationContext(),Brain_doctor.class));}

    public void Eye(View view) { startActivity(new Intent(getApplicationContext(),Eye_doctor.class));}

    public void Heart(View view) { startActivity(new Intent(getApplicationContext(),Heart_doctor.class));}

    public void Lung(View view) { startActivity(new Intent(getApplicationContext(),Lung_doctor.class));}

    public void Kidneys(View view) { startActivity(new Intent(getApplicationContext(),Kidney_doctor.class));}

    public void Ear(View view) { startActivity(new Intent(getApplicationContext(),Ear_doctor.class));}

    public void Bones(View view) { startActivity(new Intent(getApplicationContext(),Bones.class));}

    public void Teeth(View view) { startActivity(new Intent(getApplicationContext(),Teeth_doctor.class));}
}
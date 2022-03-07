package com.example.azam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Doctor_profile extends AppCompatActivity {
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    private DatabaseReference mDatabaseDoctor;
    FirebaseUser doctor = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        textView6=findViewById(R.id.doctorName);
        textView7=findViewById(R.id.doctorMail);
        textView8=findViewById(R.id.doctorHospital);
        textView9=findViewById(R.id.doctorAddress);
        textView10=findViewById(R.id.doctorSpecialist);

        mDatabaseDoctor= FirebaseDatabase.getInstance().getReference().child("doctor").child(doctor.getUid());
        mDatabaseDoctor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Doctor pinfo=snapshot.getValue(Doctor.class);
                textView6.setText(pinfo.getDoctorname());
                textView7.setText(pinfo.getDoctoremail());
                textView8.setText(pinfo.getDoctorhospitalname());
                textView9.setText(pinfo.getDoctoraddress());
                textView10.setText(pinfo.getDoctorspecialist());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
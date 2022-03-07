package com.example.azam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Doctor_register extends AppCompatActivity {

    TextInputEditText etdoctorname;
    TextInputEditText etdoctorRegEmail;
    TextInputEditText etdoctorRegPass;
    TextInputEditText etdoctorcRegPass;

    TextInputEditText etdoctorphno;
    TextInputEditText eteduqualification;
    TextInputEditText etaeduinstitution;
    TextInputEditText etaspecialist;
    TextInputEditText etahospitalname;
    TextInputEditText etdoctoraddress;
    TextView tvLoginHere;
    Button btnRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        //start
        etdoctorname = findViewById(R.id.etdoctorname);
        etdoctorRegEmail = findViewById(R.id.etdoctorRegEmail);
        etdoctorRegPass=findViewById(R.id.etdoctorRegPass);
        etdoctorRegPass=findViewById(R.id.etdoctorRegPass);
        etdoctorcRegPass=findViewById(R.id.etdoctorcRegPass);
        etdoctorphno=findViewById(R.id.etdoctorphno);
        eteduqualification=findViewById(R.id.eteduqualification);
        etaeduinstitution=findViewById(R.id.etaeduinstitution);
        etaspecialist= findViewById(R.id.etaspecialist);
        etahospitalname= findViewById(R.id.etahospitalname);
        etdoctoraddress= findViewById(R.id.etdoctoraddress);
        tvLoginHere = findViewById(R.id.tvLoginHere);
        btnRegister = findViewById(R.id.btnRegister);





        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view ->{
            createDoctor();
        });

        tvLoginHere.setOnClickListener(view ->{
            startActivity(new Intent(Doctor_register.this, Doctor_login.class));
        });
    }


    private void createDoctor(){
        String name = etdoctorname.getText().toString();
        String email = etdoctorRegEmail.getText().toString();
        String password = etdoctorRegPass.getText().toString();
        String cpassword = etdoctorcRegPass.getText().toString();
        String phno=etdoctorphno.getText().toString();
        String qualification=eteduqualification.getText().toString();
        String institution=etaeduinstitution.getText().toString();
        String specialist=etaspecialist.getText().toString();
        String hospitalname=etahospitalname.getText().toString();
        String address=etdoctoraddress.getText().toString();


        if (TextUtils.isEmpty(name)){
            etdoctorname.setError("Email cannot be empty");
            etdoctorname.requestFocus();
        }
        else if(TextUtils.isEmpty(email))
        {
            etdoctorRegEmail.setError("Enter your birth day.");
            etdoctorRegEmail.requestFocus();
        }

        else if(TextUtils.isEmpty(password))
        {
            etdoctorRegPass.setError("Enter your Name.");
            etdoctorRegPass.requestFocus();
        }

        else if(TextUtils.isEmpty(phno))
        {
            etdoctorphno.setError("Enter your phone number.");
            etdoctorphno.requestFocus();
        }

        else if(TextUtils.isEmpty(qualification))
        {
            eteduqualification.setError("Enter your address.");
            eteduqualification.requestFocus();
        }
        else if (TextUtils.isEmpty(institution)){
            etaeduinstitution.setError("Password cannot be empty");
            etaeduinstitution.requestFocus();

        }

        else if (TextUtils.isEmpty(specialist)){
            etaspecialist.setError("Password cannot be empty");
            etaspecialist.requestFocus();

        }
        //hospitalname
        else if (TextUtils.isEmpty(hospitalname)){
            etahospitalname.setError("Password cannot be empty");
            etahospitalname.requestFocus();

        }
        //address
        else if (TextUtils.isEmpty(address)){
            etdoctoraddress.setError("Password cannot be empty");
            etdoctoraddress.requestFocus();

        }

        else if (!password.equals(cpassword) ){
            Toast.makeText(Doctor_register.this,"Password Not matching",Toast.LENGTH_SHORT).show();

        }



        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        //real time database
                        String Uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                        Doctor doctor = new Doctor(Uid,name,email,password,phno,qualification,institution,
                                specialist,hospitalname,address);
                        FirebaseDatabase.getInstance().getReference("doctor")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(doctor);

                        //end real time
                        Toast.makeText(Doctor_register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Doctor_register.this, Doctor_login.class));
                    }else{
                        Toast.makeText(Doctor_register.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}



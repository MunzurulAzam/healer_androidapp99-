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

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText etRegEmail;
    TextInputEditText etRegPassword;
    TextInputEditText etRegcPass;
    TextInputEditText etDatepicker;
    TextInputEditText etName;
    TextInputEditText etAddress;
    TextInputEditText etphno;
    TextView tvLoginHere;
    Button btnRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //start
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPass);
        etRegcPass = findViewById(R.id.etRegcPass);
        tvLoginHere = findViewById(R.id.tvLoginHere);
        btnRegister = findViewById(R.id.btnRegister);
        etDatepicker=findViewById(R.id.etDatepicker);
        etName=findViewById(R.id.etname);
        etphno=findViewById(R.id.etphno);
        etAddress=findViewById(R.id.etaddress);



        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view ->{
            createUser();
        });

        tvLoginHere.setOnClickListener(view ->{
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }


    private void createUser(){
        String email = etRegEmail.getText().toString();
        String password = etRegPassword.getText().toString();
        String Cpassword = etRegcPass.getText().toString();
        String bdate = etDatepicker.getText().toString();
        String uname=etName.getText().toString();
        String uphno=etphno.getText().toString();
        String uadr=etAddress.getText().toString();

        if (TextUtils.isEmpty(email)){
            etRegEmail.setError("Email cannot be empty");
            etRegEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(bdate))
        {
            etDatepicker.setError("Enter your birth day.");
            etDatepicker.requestFocus();
        }
        //name
        else if(TextUtils.isEmpty(uname))
        {
            etName.setError("Enter your Name.");
            etName.requestFocus();
        }
        //ph number
        else if(TextUtils.isEmpty(uphno))
        {
            etphno.setError("Enter your phone number.");
            etphno.requestFocus();
        }
        //address
        else if(TextUtils.isEmpty(uadr))
        {
            etAddress.setError("Enter your address.");
            etAddress.requestFocus();
        }
        else if (TextUtils.isEmpty(password)){
            etRegPassword.setError("Password cannot be empty");
            etRegPassword.requestFocus();

        }

        else if (TextUtils.isEmpty(Cpassword)){
            etRegcPass.setError("Confirm Password cannot be empty");
            etRegcPass.requestFocus();

        }


        else if (!password.equals(Cpassword) ){
            Toast.makeText(RegisterActivity.this,"Password Not matching",Toast.LENGTH_SHORT).show();

        }





        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        //real time database
                        String Uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                        User user = new User(Uid,email,password,bdate,uname,uphno,uadr);
                        FirebaseDatabase.getInstance().getReference("user")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);

                        //end real time
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}
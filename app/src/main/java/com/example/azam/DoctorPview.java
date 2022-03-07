package com.example.azam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorPview extends AppCompatActivity {
    private String mpostkey=null;
    private String docname=null;
    private String docemail=null;
    private String dochospital=null;
    private String docaddress=null;
    private String docspecialist=null;
    private TextView textView1,textView2,textView3,textView4,textView5;
    private Button button;
    private DatabaseReference mDatabaseUser;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private boolean isPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_pview);
        //hooks

        textView1=(TextView)findViewById(R.id.docName);
        textView2=(TextView) findViewById(R.id.docMail);
        textView3=(TextView)findViewById(R.id.docHospital);
        textView4=(TextView) findViewById(R.id.docAddress);
        textView5=(TextView) findViewById(R.id.docSpecialist);
        button=(Button) findViewById(R.id.connectbtn);
        mpostkey=getIntent().getExtras().getString("Package_id");
        docname=getIntent().getExtras().getString("doctorname");
        docemail=getIntent().getExtras().getString("doctoremail");
        dochospital=getIntent().getExtras().getString("doctorhospitalname");
        docaddress=getIntent().getExtras().getString("doctoraddress");
        docspecialist=getIntent().getExtras().getString("doctorspecialist");


        textView1.setText(docname);
        textView2.setText(docemail);
        textView3.setText(dochospital);
        textView4.setText(docaddress);
        textView5.setText(docspecialist);

        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
               /* final String rname=mname;
                final String rgender=mgender;
                final String rsub =msub;
                final String rmail=mmail;
                final String key=mpostkey;
                //Request request = new Request(key,rname,rgender,rsub,rmail);
                Users users = new Users(uid,name,email,gender,subject);
                FirebaseDatabase.getInstance().getReference("request")
                        .child(mpostkey).setValue(request);

                Toast.makeText(getApplicationContext(),"Request Sent!",Toast.LENGTH_SHORT).show();
                finish();

                startActivity(new Intent(getApplicationContext(),Findstudyp.class));*/


                mDatabaseUser= FirebaseDatabase.getInstance().getReference().child("user").child(user.getUid());

                mDatabaseUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        User userProfileInfo = snapshot.getValue(User.class);
                        FirebaseDatabase.getInstance().getReference("appoint")
                                .child(mpostkey).child(user.getUid()).setValue(userProfileInfo);
                        Toast.makeText(DoctorPview.this,"Sent Appointment Succesfully And Wait For The Email",Toast.LENGTH_LONG).show();

                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(DoctorPview.this, Doctor_Pannel.class);
        finish();
        startActivity(intent);
    }

    }

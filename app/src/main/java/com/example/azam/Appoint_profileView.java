package com.example.azam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Appoint_profileView extends AppCompatActivity {
    private String mpostkey=null;
    private String mname=null;
    private String memail=null;
    private String mphno=null;
    private DatabaseReference mDatabaseUser;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView textView1,textView2,textView3;
    private Button button,btn;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint_profile_view);
        textView1=(TextView)findViewById(R.id.pname);
        textView2=(TextView) findViewById(R.id.pMail);
        textView3=(TextView)findViewById(R.id.pno);
        button=(Button) findViewById(R.id.accept);
        btn=(Button)findViewById(R.id.reject);

        final String Uid= FirebaseAuth.getInstance().getCurrentUser().getUid();

        mDatabase=FirebaseDatabase.getInstance().getReference().child("appoint").child(Uid);

        mpostkey=getIntent().getExtras().getString("Package_id");
        mname=getIntent().getExtras().getString("username");
        memail=getIntent().getExtras().getString("email");
        mphno=getIntent().getExtras().getString("userphno");

        textView1.setText(mname);
        textView2.setText(memail);
        textView3.setText(mphno);

        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                final String rname=mname;
                final String remail=memail;
                final String rphno =mphno;
                final String key=mpostkey;

                Acceptmodel acceptmodel = new Acceptmodel(key,rname,remail,rphno);
                FirebaseDatabase.getInstance().getReference("acceptedpatient")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(mpostkey).setValue(acceptmodel);





                //removing request
                Toast.makeText(getApplicationContext(),"Accepted!",Toast.LENGTH_SHORT).show();
                mDatabase.child(key).removeValue();
                startActivity(new Intent(getApplicationContext(),Appointment.class));
                finish();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Appoint_profileView.this);
                builder.setMessage("Are you sure you want to remove the post ? ").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String key=mpostkey;
                        mDatabase.child(key).removeValue();
                        Intent ToCurrentUserPost = new Intent(Appoint_profileView.this,Appointment.class);
                        finish();
                        startActivity(ToCurrentUserPost);


                    }
                }).setNegativeButton("Cancel",null);
                AlertDialog alert=builder.create();
                alert.show();

            }
        });



    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Appoint_profileView.this,Appointment.class);
        finish();
        startActivity(intent);
    }

}
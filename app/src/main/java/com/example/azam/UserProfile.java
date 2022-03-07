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

public class UserProfile extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    private DatabaseReference mDatabaseUser;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView1=findViewById(R.id.userName);
        textView2=findViewById(R.id.userEmail);
        textView3=findViewById(R.id.userPhn);
        textView4=findViewById(R.id.userAddress);
        textView5=findViewById(R.id.userDatebirth);

        mDatabaseUser= FirebaseDatabase.getInstance().getReference().child("user").child(user.getUid());
        mDatabaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User pinfo=snapshot.getValue(User.class);
                textView1.setText(pinfo.getUsername());
                textView2.setText(pinfo.getEmail());
                textView3.setText(pinfo.getUserphno());
                textView4.setText(pinfo.getUseraddress());
                textView5.setText(pinfo.getBdate());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
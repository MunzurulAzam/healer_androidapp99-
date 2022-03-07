package com.example.azam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MypatientList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabaseP;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypatient_list);

        recyclerView = (RecyclerView) findViewById(R.id.prec);
        mAuth = FirebaseAuth.getInstance();
        mDatabaseP = FirebaseDatabase.getInstance().getReference().child("acceptedpatient");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onStart() {
        super.onStart();
        final String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("acceptedpatient").child(Uid);
        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(query, User.class)
                        .build();
        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<User, MypatientList.PackageViewHolder>(options) {

            @Override
            public MypatientList.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Used same procedure as the posting options for pulling and setting information from database
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.usersinglerow, parent, false);
                //FirebaseDatabase.getInstance().getReference().child("users").child(Uid);
                return new MypatientList.PackageViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(MypatientList.PackageViewHolder holder, int position, User User) {

                String post_key = getRef(position).getKey();
                final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                holder.setName(User.getUsername());
                holder.setEmail(User.getEmail());
                holder.setPhno(User.getUserphno());


/*                if(model.getUid() ==userid ){

                    Uid.setVisibility(View.GONE);
                }*/


                holder.mView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(PackageOptions.this,post_key,Toast.LENGTH_SHORT).show();

//                        Intent SinglePackageIntent = new Intent(Appointment.this, Appoint_profileView.class);
//                        SinglePackageIntent.putExtra("Package_id", post_key);
//                        SinglePackageIntent.putExtra("username",User.getUsername());
//                        SinglePackageIntent.putExtra("email",User.getEmail());
//                        SinglePackageIntent.putExtra("userphno", User.getUserphno());
//
//
//                        finish();
//                        startActivity(SinglePackageIntent);

                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("plain/text");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { User.getEmail() });
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Healer");
                        intent.putExtra(Intent.EXTRA_TEXT, " ");
                        startActivity(Intent.createChooser(intent, ""));



                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }


    public static class PackageViewHolder extends RecyclerView.ViewHolder {

        View mView;


        FirebaseAuth mAuth;


        /**
         * Holder function to fit data as a item
         *
         * @param itemView
         */
        public PackageViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            mAuth = FirebaseAuth.getInstance();
        }



        public void setName(String sname) {

            TextView name = (TextView) mView.findViewById(R.id.sname);
            name.setText(sname);

        }

        public void setEmail(String smail) {

            TextView mail = (TextView) mView.findViewById(R.id.semail);
            mail.setText(smail);

        }

        public void setPhno(String phno) {

            TextView phone = (TextView) mView.findViewById(R.id.sphno);
            phone.setText(phno);

        }


    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}



//end


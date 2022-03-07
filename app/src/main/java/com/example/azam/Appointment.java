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

public class Appointment extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabaseP;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        //hooks
        recyclerView = (RecyclerView) findViewById(R.id.appointrec);
        mAuth = FirebaseAuth.getInstance();
        mDatabaseP = FirebaseDatabase.getInstance().getReference().child("appoint");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

//start

    @Override
    protected void onStart() {
        super.onStart();
        final String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("appoint").child(Uid);
        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(query, User.class)
                        .build();
        //Recycler for viewing the information of posts from database
        //  FirebaseDatabase.getInstance().getReference().child("users").child(Uid);

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<User, Appointment.PackageViewHolder>(options) {

            @Override
            public Appointment.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Used same procedure as the posting options for pulling and setting information from database
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.usersinglerow, parent, false);
                //FirebaseDatabase.getInstance().getReference().child("users").child(Uid);
                return new Appointment.PackageViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(Appointment.PackageViewHolder holder, int position, User User) {

                String post_key = getRef(position).getKey();
                final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                holder.setName(User.getUsername());
                holder.setEmail(User.getEmail());
                holder.setPhno(User.getUserphno());


/*                if(model.getUid() ==userid ){

                    Uid.setVisibility(View.GONE);
                }*/


                holder.mView.setOnClickListener(new View.OnClickListener() {
                    /**
                     * It is the onClick function to sent data to Profile view
                     * @param v
                     */
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(PackageOptions.this,post_key,Toast.LENGTH_SHORT).show();

                        Intent SinglePackageIntent = new Intent(Appointment.this, Appoint_profileView.class);
                        SinglePackageIntent.putExtra("Package_id", post_key);
                        SinglePackageIntent.putExtra("username",User.getUsername());
                        SinglePackageIntent.putExtra("email",User.getEmail());
                        SinglePackageIntent.putExtra("userphno", User.getUserphno());


                        finish();
                        startActivity(SinglePackageIntent);


                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

    /**
     * Package holder to fit data into recycler view
     */
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


        /**
         * Set Name into Text view in single row using model java.
         *
         * @param docname
         */
        public void setName(String docname) {

            TextView name = (TextView) mView.findViewById(R.id.sname);
            name.setText(docname);

        }

        public void setEmail(String docemail) {

            TextView gender = (TextView) mView.findViewById(R.id.semail);
            gender.setText(docemail);

        }


        public void setPhno(String phno) {

            TextView subject = (TextView) mView.findViewById(R.id.sphno);
            subject.setText(phno);

        }


    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}



//end


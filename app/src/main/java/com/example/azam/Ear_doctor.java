package com.example.azam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Ear_doctor extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabaseP;
    private FirebaseAuth mAuth;
    EditText searchText;
    ImageButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ear_doctor);

        //hooks
        recyclerView=(RecyclerView)findViewById(R.id.recFordoctor);
        mAuth=FirebaseAuth.getInstance();
        mDatabaseP= FirebaseDatabase.getInstance().getReference().child("doctor");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchText=findViewById(R.id.searchText);
        btn=findViewById(R.id.searchBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTxt=searchText.getText().toString();
                firebaseDoctorSearch(searchTxt);
            }
        });
    }

    private void firebaseDoctorSearch(String searchTxt) {
        Toast.makeText(Ear_doctor.this,"Start search",Toast.LENGTH_LONG).show();

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("doctor").orderByChild("doctorname").startAt(searchTxt).endAt(searchTxt+"\uf8ff");
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(query, model.class)
                        .build();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<model, Ear_doctor.PackageViewHolder>(options) {

            @Override
            public Ear_doctor.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Used same procedure as the posting options for pulling and setting information from database
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.singlerow, parent, false);
                //FirebaseDatabase.getInstance().getReference().child("users").child(Uid);
                return new Ear_doctor.PackageViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(Ear_doctor.PackageViewHolder holder, int position, model model) {

                String post_key = getRef(position).getKey();
                final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                holder.setName(model.getDoctorname());
                holder.setEmail(model.getDoctoremail());
                holder.setHospital(model.getDoctorhospitalname());
                holder.setAddress(model.getDoctoraddress());
                holder.setSpecialist(model.getDoctorspecialist());






                holder.mView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(PackageOptions.this,post_key,Toast.LENGTH_SHORT).show();

                        Intent SinglePackageIntent = new Intent(Ear_doctor.this,DoctorPview.class);
                        SinglePackageIntent.putExtra("Package_id",post_key);
                        SinglePackageIntent.putExtra("doctorname",model.getDoctorname());
                        SinglePackageIntent.putExtra("doctoremail",model.getDoctoremail());
                        SinglePackageIntent.putExtra("doctorhospitalname",model.getDoctorhospitalname());
                        SinglePackageIntent.putExtra("doctoraddress",model.getDoctoraddress());
                        SinglePackageIntent.putExtra("doctorspecialist",model.getDoctorspecialist());


                        finish();
                        startActivity(SinglePackageIntent);


                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();


    }
    //start



    @Override
    protected void onStart() {
        super.onStart();
        final String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("doctor").orderByChild("doctorspecialist").equalTo("Ear");
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(query, model.class)
                        .build();
        //Recycler for viewing the information of posts from database
        //  FirebaseDatabase.getInstance().getReference().child("users").child(Uid);

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<model, Ear_doctor.PackageViewHolder>(options) {
            /**
             * Creating View holder to fit data into single row xml .
             * @param parent
             * @param viewType
             * @return
             */
            @Override
            public Ear_doctor.PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Used same procedure as the posting options for pulling and setting information from database
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.singlerow, parent, false);
                //FirebaseDatabase.getInstance().getReference().child("users").child(Uid);
                return new Ear_doctor.PackageViewHolder(view);
            }

            /**
             * Creating Adapter to hold data.
             * @param holder
             * @param position
             * @param model
             */
            @Override
            protected void onBindViewHolder(Ear_doctor.PackageViewHolder holder, int position, model model) {

                String post_key = getRef(position).getKey();
                final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                holder.setName(model.getDoctorname());
                holder.setEmail(model.getDoctoremail());
                holder.setHospital(model.getDoctorhospitalname());
                holder.setAddress(model.getDoctoraddress());
                holder.setSpecialist(model.getDoctorspecialist());

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

                        Intent SinglePackageIntent = new Intent(Ear_doctor.this,DoctorPview.class);
                        SinglePackageIntent.putExtra("Package_id",post_key);
                        SinglePackageIntent.putExtra("doctorname",model.getDoctorname());
                        SinglePackageIntent.putExtra("doctoremail",model.getDoctoremail());
                        SinglePackageIntent.putExtra("doctorhospitalname",model.getDoctorhospitalname());
                        SinglePackageIntent.putExtra("doctoraddress",model.getDoctoraddress());
                        SinglePackageIntent.putExtra("doctorspecialist",model.getDoctorspecialist());


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
    public static class PackageViewHolder extends RecyclerView.ViewHolder{

        View mView;


        FirebaseAuth mAuth;


        /**
         * Holder function to fit data as a item
         * @param itemView
         */
        public PackageViewHolder(View itemView) {
            super(itemView);

            mView=itemView;

            mAuth= FirebaseAuth.getInstance();
        }


        /**
         * Set Name into Text view in single row using model java.
         * @param docname
         */
        public void setName(String docname){

            TextView name = (TextView) mView.findViewById(R.id.nametext);
            name.setText(docname);

        }

        public void setEmail(String docemail){

            TextView gender = (TextView) mView.findViewById(R.id.emailtext);
            gender.setText(docemail);

        }


        public void setHospital(String dochospital){

            TextView subject = (TextView) mView.findViewById(R.id.chambertext);
            subject.setText(dochospital);

        }


        public void setAddress(String docaddress){

            TextView email = (TextView) mView.findViewById(R.id.addresstext);
            email.setText(docaddress);

        }
        public void setSpecialist(String docspecialist){

            TextView email = (TextView) mView.findViewById(R.id.specialisttext);
            email.setText(docspecialist);

        }


    }

    @Override
    protected void onStop() {
        super.onStop();

    }



    //end

}
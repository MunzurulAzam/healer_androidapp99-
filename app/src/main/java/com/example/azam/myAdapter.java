package com.example.azam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<model,myAdapter.myviewholder>{

    public myAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.name.setText(model.getDoctorname());
        holder.email.setText(model.getDoctoremail());
        holder.phone.setText(model.getDoctorphno());
        holder.education.setText(model.getDoctorqualification());
        holder.educationInstitution.setText(model.getDoctorinstitution());
        holder.specialist.setText(model.getDoctorspecialist());
        holder.chamber.setText(model.getDoctorhospitalname());
        holder.address.setText(model.getDoctoraddress());




    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        View mView;
        TextView name,email,phone,education,educationInstitution,specialist,chamber,address;
        public myviewholder(@NonNull View itemView) {

            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
            phone=(TextView)itemView.findViewById(R.id.phonetext);
            education=(TextView)itemView.findViewById(R.id.educationtext);
            educationInstitution=(TextView)itemView.findViewById(R.id.educationInstitutiontext);
            specialist=(TextView)itemView.findViewById(R.id.specialisttext);
            chamber=(TextView)itemView.findViewById(R.id.chambertext);
            address=(TextView)itemView.findViewById(R.id.addresstext);
        }

    }
}

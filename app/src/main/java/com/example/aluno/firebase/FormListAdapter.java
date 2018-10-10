package com.example.aluno.firebase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormListAdapter extends RecyclerView.Adapter<FormListAdapter.FormViewHolder> {

    DatabaseReference database;

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        database = FirebaseDatabase.getInstance().getReference();

        return new FormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
        //Dados vindos do Firebase

        String nome = database.child("Usuario").child("Nome").toString();
        String email = database.child("Usuario").child("Email").toString();

        holder.textEmail.setText(email);
        holder.textNome.setText(nome);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FormViewHolder extends RecyclerView.ViewHolder{
        TextView textNome;
        TextView textEmail;
        public FormViewHolder(@NonNull  View v){
            super(v);

            textNome = v.findViewById(R.id.textViewNome);
            textEmail = v.findViewById(R.id.textViewEmail);
        }
    }


}

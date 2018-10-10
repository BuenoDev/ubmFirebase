package com.example.aluno.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference database;

    EditText editNome;
    EditText editEmail;
    Button btn;

    RecyclerView recyclerView;
    RecyclerView.Adapter viewAdapter;
    RecyclerView.LayoutManager viewManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance().getReference();

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        btn = findViewById(R.id.btn);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        viewAdapter = new FormListAdapter();
        recyclerView.setAdapter(viewAdapter);

        viewManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(viewManager);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString();
                String email = editEmail.getText().toString();

                database.child("Usuario").child("Nome").setValue(nome);
                database.child("Usuario").child("Email").setValue(email);
            }
        });
    }
}

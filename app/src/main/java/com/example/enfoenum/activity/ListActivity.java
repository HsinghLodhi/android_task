package com.example.enfoenum.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.enfoenum.MainActivity;
import com.example.enfoenum.R;
import com.example.enfoenum.adapter.ListAdapter;
import com.example.enfoenum.model.MoviesModel;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);

        DatabaseClass db = new DatabaseClass(this);

        //db.addMovies(new MoviesModel("1","2","3"));
        List<MoviesModel> list = db.getAllMovies();


        Toast.makeText(getApplicationContext(),list.size()+"",Toast.LENGTH_LONG).show();
        ListAdapter listAdapter = new ListAdapter(ListActivity.this,list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
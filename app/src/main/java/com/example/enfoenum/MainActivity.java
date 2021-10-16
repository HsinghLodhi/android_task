package com.example.enfoenum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enfoenum.activity.DatabaseClass;
import com.example.enfoenum.activity.ListActivity;
import com.example.enfoenum.model.MoviesModel;

public class MainActivity extends AppCompatActivity {

    EditText etActressName,etActorName,etMovies;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovies = findViewById(R.id.etMovies);
        etActorName = findViewById(R.id.etActorName);
        etActressName = findViewById(R.id.etActressName);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movies = etMovies.getText().toString().trim();
                String actorName = etActorName.getText().toString().trim();
                String actressName = etActressName.getText().toString().trim();

                DatabaseClass db = new DatabaseClass(MainActivity.this);
                db.addMovies(new MoviesModel(movies,actorName,actressName));
          Toast.makeText(getApplicationContext(),"Done", Toast.LENGTH_LONG).show();

                etMovies.setText("");
                etActorName.setText("");
                etActressName.setText("");

            }
        });




    }
    
    
    public void btnShowlist(View v) {
        startActivity(new Intent(MainActivity.this, ListActivity.class));
    }
    
}
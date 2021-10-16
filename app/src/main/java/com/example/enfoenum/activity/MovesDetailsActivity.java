package com.example.enfoenum.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enfoenum.R;
import com.example.enfoenum.adapter.ListAdapter;
import com.example.enfoenum.model.MoviesModel;

import java.util.List;

public class MovesDetailsActivity extends AppCompatActivity {

    EditText tvMoviesName,tvActorName,tvActressName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moves_details);

        tvMoviesName = findViewById(R.id.tvMoviesName);
        tvActorName = findViewById(R.id.tvActorName);
        tvActressName = findViewById(R.id.tvActressName);
        DatabaseClass db = new DatabaseClass(this);
        List<MoviesModel> list = db.getAllMovies();
        MoviesModel mymodel = null;
        for(MoviesModel m : list)
        {
            if(m.getId()== ListAdapter.itemid) {
                mymodel = m;
                break;
            }
        }
        tvMoviesName.setText(mymodel.getMovies());
        tvActorName.setText(mymodel.getActor());
        tvActressName.setText(mymodel.getActress());
    }

    public void btnUpdate(View v){

        String movies = tvMoviesName.getText().toString().trim();
        String actorName = tvActorName.getText().toString().trim();
        String actressName = tvActressName.getText().toString().trim();

        MoviesModel moviesModel = new MoviesModel(movies,actorName,actressName);
        moviesModel.setId(ListAdapter.itemid);
        DatabaseClass databaseClass = new DatabaseClass(this);
        databaseClass.updateMovies(moviesModel);
        Toast.makeText(getApplicationContext(),"Update Done", Toast.LENGTH_LONG).show();

       Intent intent = new Intent(MovesDetailsActivity.this,ListActivity.class);
       startActivity(intent);
       finish();
    }
}
package com.example.enfoenum.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import com.example.enfoenum.model.MoviesModel;

import java.util.ArrayList;
import java.util.List;


public class DatabaseClass extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "moviesManager";
    private static final String TABLE_MOVIES = "movies";
    private static final String KEY_ID = "id";
    private static final String KEY_MOVIE_NAME = "name";
    private static final String KEY_ACTOR_NAME = "actorname";
    private static final String KEY_ACTRESS_NAME = "actressname";


    public DatabaseClass( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MOVIES_TABLE = "CREATE TABLE " + TABLE_MOVIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MOVIE_NAME + " TEXT,"+ KEY_ACTOR_NAME + " TEXT,"
                + KEY_ACTRESS_NAME + " TEXT" + ")";
        db.execSQL(CREATE_MOVIES_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);

        onCreate(db);
    }


   public void addMovies(MoviesModel moviesModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MOVIE_NAME, moviesModel.getMovies());
        values.put(KEY_ACTOR_NAME, moviesModel.getActor());
        values.put(KEY_ACTRESS_NAME, moviesModel.getActress());

        db.insert(TABLE_MOVIES, null, values);
        db.close();
    }


    public List<MoviesModel> getAllMovies() {
        List<MoviesModel> movieList = new ArrayList<MoviesModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MoviesModel movies = new MoviesModel();
                movies.setId(Integer.parseInt(cursor.getString(0)));
                movies.setMovies(cursor.getString(1));
                movies.setActor(cursor.getString(2));
                movies.setActress(cursor.getString(3));
                // Adding contact to list
                movieList.add(movies);
            } while (cursor.moveToNext());
        }

        return movieList;
    }


    public int updateMovies(MoviesModel moviesModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MOVIE_NAME, moviesModel.getMovies());
        values.put(KEY_ACTOR_NAME, moviesModel.getActor());
        values.put(KEY_ACTRESS_NAME, moviesModel.getActress());

        // updating row
        return db.update(TABLE_MOVIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(moviesModel.getId()) });
    }

}



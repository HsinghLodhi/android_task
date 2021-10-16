package com.example.enfoenum.model;

import java.io.Serializable;

public class MoviesModel implements Serializable {

    private String movies;
    private int id;
    private String actor;
    private String actress;

    public MoviesModel(String movies, String actorName, String actressName) {
         this.movies = movies;
         this.actor = actorName;
         this.actress = actressName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MoviesModel(){


 }
    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }
}

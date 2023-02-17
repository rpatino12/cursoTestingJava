package com.platzi.movies.model;

public class Movie {
    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;

    public Movie(String name, int minutes, Genre genre) {
        // This constructor is calling the other constructor but with a null value for the id
        this(null, name, minutes, genre);
    }

    public Movie(Integer id, String name, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }
}

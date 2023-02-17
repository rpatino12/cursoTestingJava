package com.platzi.movies.data;

import com.platzi.movies.model.Movie;

import java.util.Collection;

// Here we have an interface because we don't have the implementation of the Movie repository
// This class would be the connection to the database

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}

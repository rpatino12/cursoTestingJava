package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    // We have to connect the service layer to the data layer (repository)
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        // Here we have a few steps:
            // 1. (.findAll()) Call the movieRepository findAll() method
            // 2. (.stream().filter()) Filter the results when the movie genre is equal to the argument
            // 3. (.collect()) Convert the result to a list

        return movieRepository.findAll().stream().
                filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream().
                filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByInitial(String initial) {
        return movieRepository.findAll().stream().
                filter(movie -> movie.getName().substring(0,1).equals(initial)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findAll().stream().
                filter(movie -> movie.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }
}

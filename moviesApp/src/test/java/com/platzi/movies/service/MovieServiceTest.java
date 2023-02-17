package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService movieService;
    @Before
    public void setUp(){
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        // Here we have the collection of Comedy movies
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        // And here we get the ids of the Comedy movies
        List<Integer> moviesId = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        // Here just check the ids
        assertEquals(Arrays.asList(3, 6), moviesId);
    }

    @Test
    public void return_movies_by_length() {
        // Here we have the collection of movies with a duration less or equal to the duration indicated
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        List<Integer> moviesId = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        // Here just check the ids
        assertEquals(Arrays.asList(2, 3, 4, 5, 6), moviesId);
    }
}
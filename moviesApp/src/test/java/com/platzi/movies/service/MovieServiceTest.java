package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceTest {
    @Test
    public void return_movies_by_genre() {
        // Here we mock the repository class
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        // And here mock the behavior that the repository class would have when calling the method findAll()
        // We mock that the repository is going to return those 7 movies
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

        // Then we create the movieService instance
        MovieService movieService = new MovieService(movieRepository);

        // And here we call the movieService method findMoviesByGenre() that we want to test
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        // To check that findMoviesByGenre() is working and return only the comedy movies
        // We are going to get the movie's id, so we can check the assertion easily
        List<Integer> moviesId = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        // Here we check the id, we have to obtain only the comedy movies ids (3 and 6)
        assertEquals(Arrays.asList(3, 6), moviesId);
    }
}
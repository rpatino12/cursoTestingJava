package com.platzi.movies.data;

import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Types;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
    // We create the attribute jdbcTemplate
    // Using the spring-jdbc library, we create an instance to connect to the database
    private JdbcTemplate jdbcTemplate;

    // So we create a RowMapper to convert the data from the database to a Movie object
    // The ResultSet object rs represents the actual row of the database
    private static final RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("minutes"),
                // We have to get the enum value for genre from a string (that's why we use the getString method)
                Genre.valueOf(rs.getString("genre"))
    );

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        int[] types = { Types.INTEGER };

        // This method is use to return only one object from the database
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, types, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        // With the attribute jdbcTemplate I can get the movies from the database
        // With the method query first I pass the SQL command to execute
        // And second the formatter to parse the result to a movie object (movieMapper in this case)
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        // This method is used to send data to the data base, unlike query or queryForObject that are for get data from db
        // So we insert a new movie to the database
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) VALUES (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }
}

package com.platzi.movies.data;

import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;

    @Before
    public void setUp() throws Exception {
        // The JdbcTemplate needs a DataSource (This represents the connection to the database)
        // So we use the following method from the spring-jdbc library
        // And for the url we use the library h2database to simulate the database (creates a db in memory)
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL", "sample", "sample");

        // We need to execute the sql script from the resources directory, to create the movies table in the db
        // So we use the ScriptUtils class from the spring-jdbc library
        // Here we indicate the path to the sql script (test-data.sql in this case)
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        // Create the template that my repository needs to connect to the db
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Create the repository
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies_from_database() {
        // Now we are going to test if we can load all the movies from the database
        Collection<Movie> movies = movieRepository.findAll();

        assertEquals(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        ), movies);
    }
}
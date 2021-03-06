package br.com.platform.movies.controller;

import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.MovieDAO;
import br.com.platform.movies.model.dao.PostgresConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class MovieController {
  private MovieDAO movieDAO;
  
  public MovieController() {
    this.movieDAO = new MovieDAO();
  }
  
  public List<Movie> listAll(String nameFilter, String genreFilter, int ageRangeFilter) {
    List movies = this.movieDAO.list(nameFilter, genreFilter, ageRangeFilter);
    return movies;
  }
  
  public void createMovie(String name, String genre, String description, int duration, boolean isAvailable, int ageRange) throws Exception {
    if (ageRange < 0) {
      throw new Exception("A faixa etária deve ser maior que 0");
    }
    if (duration < 0) {
      throw new Exception("A duração deve ser maior que 0");
    }
    Movie movie = new Movie(name, genre, description, duration, isAvailable, ageRange);
    this.movieDAO.create(movie);
  }
  
  public void updateMovie(int movieId, String name, String genre, String description, int duration, boolean isAvailable, int ageRange) throws Exception {
    if (ageRange < 0) {
      throw new Exception("A faixa etária deve ser maior que 0");
    }
    if (duration < 0) {
      throw new Exception("A duração deve ser maior que 0");
    }
    
    Movie movie = this.movieDAO.findById(movieId);

    movie.setName(name);
    movie.setGenre(genre);
    movie.setDescription(description);
    movie.setDuration(duration);
    movie.setIsAvaiable(isAvailable);
    movie.setAgeRange(ageRange);

    this.movieDAO.update(movieId, movie);
  }
  
  public Movie findById(int id) throws Exception {
    Movie movie = this.movieDAO.findById(id);
    return movie;
  }
}
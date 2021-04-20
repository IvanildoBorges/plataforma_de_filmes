package br.com.platform.movies.controller;

import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.MovieDAO;
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
  
  public List<Movie> listAll() {
    List movies = this.movieDAO.list();
    return movies;
  }
  
  public void createMovie(String name, String genre, String description, int duration, boolean isAvailable, int ageRange) {
    Movie movie = new Movie(name, genre, description, duration, isAvailable, ageRange);
    this.movieDAO.create(movie);
  }
  
  public void updateMovie(int movieId, String name, String genre, String description, int duration, boolean isAvailable, int ageRange) throws Exception {
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
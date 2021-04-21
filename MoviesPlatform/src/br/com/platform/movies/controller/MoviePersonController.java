/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.controller;

import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.MoviePersonDAO;
import br.com.platform.movies.model.dao.MovieDAO;

/**
 *
 * @author elieu
 */
public class MoviePersonController {
  private MoviePersonDAO moviePersonDAO;
  private MovieDAO movieDAO;
  
  public MoviePersonController() {
    this.moviePersonDAO = new MoviePersonDAO();
    this.movieDAO = new MovieDAO();
  }
  
  public void setWatchedMovie(int userId, int movieId, int totalMinutesWatched) throws Exception {
    Movie movie = this.movieDAO.findById(movieId);

    if (movie.getDuration() < totalMinutesWatched) {
      throw new Exception("O tempo assitido deve ser menor do que o tempo total do filme");
    }
    
    boolean hasFilmBeenSeen = this.moviePersonDAO.hasFilmBeenSeen(movieId, userId);
    if (hasFilmBeenSeen) {
      throw new Exception("Esse filme já foi marcado como assitido por esse usuário");
    }
    
    this.moviePersonDAO.watchMovie(userId, movieId, totalMinutesWatched);
  }
}

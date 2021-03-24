/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.controller;

import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.MovieDAO;
import br.com.platform.movies.model.dao.PostgresConnection;
import java.sql.Connection;

/**
 *
 * @author elieu
 */
public class MovieController {
  private MovieDAO movieDAO;
  
  public MovieController() {
    this.movieDAO = new MovieDAO();
  }
  
  public void createMovie(String name, String genre, String description, int duration, boolean isAvailable, int ageRange) {
    Movie movie = new Movie(name, genre, description, duration, isAvailable, ageRange);
    this.movieDAO.create(movie);
  }
}

package br.com.platform.movies.controller;

import br.com.platform.movies.dto.PersonalStatisticsDTO;
import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.MoviePersonDAO;
import br.com.platform.movies.model.dao.MovieDAO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
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
  
  public List<Movie> getWatchedFilms (int userId) {
    List movies = this.moviePersonDAO.getWatchedMovies(userId);
    return movies;
  }
  
  public PersonalStatisticsDTO getPersonalStatistics (int userId) throws Exception {
    PersonalStatisticsDTO stats = new PersonalStatisticsDTO();
    
    int totalMinutesWatchedByUser = this.moviePersonDAO.getWatchedTimeByUser(userId);
    stats.setTotalMinutesWatchedByUser(totalMinutesWatchedByUser);
    
    Map mapa = this.moviePersonDAO.getTotalWatchedGroupedByGenre(userId);
    stats.setMapTotalByGenre(mapa);
    
    float averageMinutesWatched = this.moviePersonDAO.getTotalMinutesWatchedAverage();
    stats.setOverallAverage(averageMinutesWatched);
    
    float averageMinutesWatchedBYUser = this.moviePersonDAO.getTotalMinutesWatchedByUserAverage(userId);
    stats.setUserAverage(averageMinutesWatchedBYUser);
    
    return stats;
  }
  
  private int getDurationForAllMovies () {
    return 1;
  }
}

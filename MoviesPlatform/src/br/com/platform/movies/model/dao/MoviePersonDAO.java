/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.model.dao;

import br.com.platform.movies.model.Movie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Alves
 */
public class MoviePersonDAO extends InsertableOnDatabase{
  public void watchMovie(int userId, int movieId, int totalMinutesWatched) {
    PreparedStatement pstmt = null;
    
    try {
      pstmt = this.getConnection().prepareStatement("insert into people_movies (person_id, movie_id, minutes_watched) values (?,?,?)");
      pstmt.setInt(1, userId);
      pstmt.setInt(2, movieId);
      pstmt.setInt(3, totalMinutesWatched);
      
      pstmt.executeUpdate();
      
    } catch (Exception e) {
      System.out.println("Erro ao assistir filme: " + e.getMessage());
    }
  }
  
  public boolean hasFilmBeenSeen(int movieId, int personId) {
    PreparedStatement pstmt = null;
    
    String sql = "select * from people_movies where person_id = " + personId + " and movie_id = " + movieId + ";";
    
    try {
      pstmt = this.getConnection().prepareStatement(sql);
      
      ResultSet rs = pstmt.executeQuery();
      
      if (rs.next()) {
        return true;
      }
      
      return false;
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return true;
  }
  
  public List<Movie> getWatchedMovies(int userId) {
    return new ArrayList<Movie>();
  }
}

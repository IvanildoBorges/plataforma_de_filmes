package br.com.platform.movies.model.dao;

import br.com.platform.movies.model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    PreparedStatement pstmt = null;
    List movieslist = new ArrayList<>();
    
    String sql = "select * from movies inner join people_movies as pm on movies.id = pm.movie_id where pm.person_id = " + userId + ";";
    
    try {
      pstmt = this.getConnection().prepareStatement(sql);
      
      ResultSet result = pstmt.executeQuery();
      
      while(result.next()) {
        Movie movie = new Movie();
        
        movie.setName(result.getString(2));
        movie.setGenre(result.getString(3));
        movie.setDescription(result.getString(4));
        movie.setDuration(result.getInt(5));
        movie.setIsAvaiable(result.getBoolean(6));
        movie.setAgeRange(result.getInt(7));
        
        movieslist.add(movie);
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close(pstmt);
      this.closeConnection(this.getConnection());
    }
    return movieslist;
  }
  
  void close (Statement stmt) {
    if (stmt != null)
      try {
        stmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  private void closeConnection(Connection connection) {
    try {
      connection.close();
    } catch (Exception e) {
      System.err.println("Erro when trying close database connection");
    }
  }
}

package br.com.platform.movies.model.dao;

import br.com.platform.movies.dto.PersonalStatisticsDTO;
import br.com.platform.movies.model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  
  public int getWatchedTimeByUser(int userId) throws Exception {
    int totalMinutesWatched = 0;
    PreparedStatement pstmt = null;
    String sql = "select minutes_watched from people_movies where person_id=?;";
    
    pstmt = this.getConnection().prepareStatement(sql);
    pstmt.setInt(1, userId);
    ResultSet result = pstmt.executeQuery();
    
    while(result.next()) {
      totalMinutesWatched += result.getInt(1);
    }
    
    return totalMinutesWatched;
  }
  
  public Map getTotalWatchedGroupedByGenre(int userId) throws Exception{
    PreparedStatement pstmt = null;
    String sql = "select m.genre, count(*) as quantity from movies m inner join people_movies pm on m.id = pm.movie_id and pm.person_id=? group by genre;";
    
    pstmt = this.getConnection().prepareStatement(sql);
    pstmt.setInt(1, userId);
    ResultSet result = pstmt.executeQuery();
    
    Map genreMap = new HashMap<>();
    
    while(result.next()) {
      String genreName = result.getString(1);
      int total = result.getInt(2);
      genreMap.put(genreName, total);
    }
    
    return genreMap;
  }
  
  public float getTotalMinutesWatchedAverage() throws Exception {
    float totalMinutesWatched = 0;
    PreparedStatement pstmt = null;
    String sql = "select avg(minutes_watched) from people_movies;";
    
    pstmt = this.getConnection().prepareStatement(sql);
    ResultSet result = pstmt.executeQuery();
    
    if (result.next()) {
      totalMinutesWatched = result.getFloat(1);
    }
    
    return totalMinutesWatched;
  }
  
  public float getTotalMinutesWatchedByUserAverage(int userId) throws Exception {
    float totalMinutesWatched = 0;
    PreparedStatement pstmt = null;
    String sql = "select avg(minutes_watched) from people_movies where person_id=?;";
    
    pstmt = this.getConnection().prepareStatement(sql);
    pstmt.setInt(1, userId);
    ResultSet result = pstmt.executeQuery();
    
    if (result.next()) {
      totalMinutesWatched = result.getFloat(1);
    }
    
    return totalMinutesWatched;
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

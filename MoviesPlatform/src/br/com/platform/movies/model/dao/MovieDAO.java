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
 * @author Ivanildo Borges
 */
public class MovieDAO extends InsertableOnDatabase {
  public int create(Movie movie) {
    PreparedStatement pstmt = null;
    int ret = 0;
    try {
      pstmt = this.getConnection().prepareStatement("insert into movies (name, genre, description, duration_in_minutes, is_available, age_range) values(?,?,?,?,?,?);");
      pstmt.setString(1, movie.getName());
      pstmt.setString(2, movie.getGenre());
      pstmt.setString(3, movie.getDescription());
      pstmt.setInt(4, movie.getDuration());
      pstmt.setBoolean(5, movie.isIsAvaiable());
      pstmt.setInt(6, movie.getAgeRange());
      
      ret = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close(pstmt);
      this.closeConnection(this.getConnection());
    }
    return ret;
  }
  
  public int update(int id, Movie movie) {
    PreparedStatement pstmt = null;
    int ret = 0;
    try {
      pstmt = this.getConnection().prepareStatement("update movies set name=?, genre=?, description=?, duration_in_minutes=?, is_available=?, age_range=? where id = ?;");
      pstmt.setString(1, movie.getName());
      pstmt.setString(2, movie.getGenre());
      pstmt.setString(3, movie.getDescription());
      pstmt.setInt(4, movie.getDuration());
      pstmt.setBoolean(5, movie.isIsAvaiable());
      pstmt.setInt(6, movie.getAgeRange());
      pstmt.setInt(7, id);

      ret = pstmt.executeUpdate();
    } catch (SQLException e) {
      String errorMessage = "Erro ao atualizar filme";
      System.out.println(errorMessage + e.getMessage());
    } finally {
      // this.close(pstmt);
      //this.closeConnection(this.getConnection());
    }
    return ret;
  }
  
  public int delete() {
    return 0;
  }
  
  public List<Movie> list(String nameFilter, String genreFilter, int ageRange) {
    PreparedStatement pstmt = null;
    List movieslist = new ArrayList<>();
    
    String sql = "select * from movies";
    
    if (!nameFilter.isEmpty()) {
      sql = sql +  " where name ilike '%" + nameFilter + "%'";
    } else if (!genreFilter.isEmpty()) {
      sql = sql +  " where genre ilike '%" + genreFilter + "%'";
    } else if (ageRange > 0) {
      sql = sql +  " where age_range = " + ageRange;
    }
    
    sql += ";";
    
    System.out.println(sql);

    try {
      pstmt = this.getConnection().prepareStatement(sql);
      
      ResultSet result = pstmt.executeQuery();
      
      while(result.next()) {
        Movie movie = new Movie();
        
        movie.setId(result.getInt(1));
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
//      this.close(pstmt);
//      this.closeConnection(this.getConnection());
    }
    return movieslist;
  }
  
  public Movie findById(int id) throws Exception {
    PreparedStatement pstmt = null;
    Movie movie = new Movie();

    try {
      pstmt = this.getConnection().prepareStatement("select * from movies where id = ?;");
      pstmt.setInt(1, id);
      
      ResultSet result = pstmt.executeQuery();
      
      result.next();
      
      movie.setId(result.getInt(1));
      movie.setName(result.getString(2));
      movie.setGenre(result.getString(3));
      movie.setDescription(result.getString(4));
      movie.setDuration(result.getInt(5));
      movie.setIsAvaiable(result.getBoolean(6));
      movie.setAgeRange(result.getInt(7));
    } catch (SQLException e) {
      this.close(pstmt);
      this.closeConnection(this.getConnection());
      throw new Exception("Filme não encontrado");
    }
    return movie;
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

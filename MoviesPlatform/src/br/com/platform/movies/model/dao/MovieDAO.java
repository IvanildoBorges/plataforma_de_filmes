/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.model.dao;

import br.com.platform.movies.model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author elieu
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
    }
    return ret;
  }
  
  public int update() {
    return 0;
  }
  
  public int delete() {
    return 0;
  }
  
  public int list() {
    return 0;
  }
  
  public int findById() {
    return 0;
  }
  
  void close (Statement stmt) {
    if (stmt != null)
      try {
        stmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}

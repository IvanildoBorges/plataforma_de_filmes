package br.com.platform.movies.model.dao;

import java.sql.Connection;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public abstract class InsertableOnDatabase {
  private Connection connection;
  
  public InsertableOnDatabase() {
    this.connection = PostgresConnection.openConnection();
  }
  
  public Connection getConnection() {
    return this.connection;
  }
}
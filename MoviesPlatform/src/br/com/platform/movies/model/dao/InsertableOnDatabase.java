/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.model.dao;

import java.sql.Connection;

/**
 *
 * @author elieu
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

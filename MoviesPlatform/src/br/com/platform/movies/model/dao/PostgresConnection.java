package br.com.platform.movies.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class PostgresConnection {
  private static final String DATABASE_DRIVER = "org.postgresql.Driver";
  private static final String DATABASE_CONNECTION_URL = "jdbc:postgresql://localhost:5432/movies-platform";
  private static final String DATABASE_USERNAME = "postgres";
  private static final String DATABASE_PASSWORD = "postgres";

  public static Connection openConnection() {
    Connection connection = null;

    try {
      Class.forName(DATABASE_DRIVER);
      connection = DriverManager.getConnection(
        DATABASE_CONNECTION_URL,
        DATABASE_USERNAME,
        DATABASE_PASSWORD
      );
      System.out.println("SUCCESSFULLY CONNECT TO POSTRES");
    } catch (Exception e) {
      System.err.println("ERRO CONNECTING TO POSTRES: " + e.getMessage());
    }

    return connection;
  }
  
  public static void closeConnection(Connection connection) {
    try {
      connection.close();
      System.out.println("CONNECTION SUCCESSFULLY CLOSED");
    } catch (Exception e) {
      System.err.println("ERRO CLOSING DATABASE CONNECTION: " + e.getMessage());
    }
  }
}
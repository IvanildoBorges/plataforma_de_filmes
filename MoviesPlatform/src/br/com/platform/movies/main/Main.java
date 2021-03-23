/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.main;

import br.com.platform.movies.model.dao.PostgresConnection;
import java.sql.Connection;

/**
 *
 * @author Elieudo Maia
 */
public class Main {
  public static void main(String[] args) {
    Connection c = PostgresConnection.openConnection();
    PostgresConnection.closeConnection(c);
  }
}

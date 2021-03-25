package br.com.platform.movies.main;

import br.com.platform.movies.controller.MovieController;
import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.PostgresConnection;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class Main {
  public static void main(String[] args) {
    MovieController mc = new MovieController();
    
//    criando filme
//    mc.createMovie("Hora de dormir", "Humor", "Filme de humor", 130, true, 14);

//    Listando todos os filmes
//    List<Movie> listaFilmes = mc.listAll();
//    
//    for(Movie m : listaFilmes) {
//      System.out.println(m.getName());
//      System.out.println(m.getDescription());
//      System.out.println(m.getDuration());
//    }

//    Procurar filme pelo ID
//    Movie m = null;
//    try {
//      m = mc.findById(3);
//    } catch (Exception ex) {
//      System.out.println(ex.getMessage());
//    }
//    
//    if (m instanceof Movie) {
//      System.out.println("&&&&&&&" + m.getName());
//    }

  }
}
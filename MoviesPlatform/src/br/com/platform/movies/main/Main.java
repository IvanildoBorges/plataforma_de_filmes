package br.com.platform.movies.main;

import br.com.platform.movies.controller.MovieController;
import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.dao.PostgresConnection;
import java.sql.Connection;
import java.util.List;

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
    List<Movie> listaFilmes = mc.listAll();
    
    for(Movie m : listaFilmes) {
      System.out.println(m.getName());
      System.out.println(m.getDescription());
      System.out.println(m.getDuration());
    }

  }
}
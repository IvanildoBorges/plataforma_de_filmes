package br.com.platform.movies.main;

import br.com.platform.movies.controller.MovieController;
import br.com.platform.movies.controller.PersonController;
import br.com.platform.movies.model.Movie;
import br.com.platform.movies.view.Home;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class Main {
  public static void main(String[] args) throws ParseException {
      System.out.println("Starting application ...");
      new Home().setVisible(true);
    
//    MovieController mc = new MovieController();
//    
//    //criando filme
//    mc.createMovie("Hora de dormir", "Humor", "Filme de humor", 130, true, 14);
//
//    //Listando todos os filmes
//    List<Movie> listaFilmes = mc.listAll();
//    
//    for(Movie m : listaFilmes) {
//      System.out.println(m.getName());
//      System.out.println(m.getDescription());
//      System.out.println(m.getDuration());
//    }
//
//    //Procurar filme pelo ID
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

      PersonController pc = new PersonController(); 
      Date birth = new Date(1997, 9, 18);
      try {
        pc.create("Elieudo Maia", "elieudo.maia@gmail.com", "123", "88998758585", "Em casa", birth);
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }

  }
}
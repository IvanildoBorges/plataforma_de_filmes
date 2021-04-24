package br.com.platform.movies.main;

import br.com.platform.movies.controller.MovieController;
import br.com.platform.movies.controller.MoviePersonController;
import br.com.platform.movies.controller.PersonController;
import br.com.platform.movies.model.Movie;
import br.com.platform.movies.model.Person;
import br.com.platform.movies.view.Home;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//    List<Movie> listaFilmes = mc.listAll("", "", 0);
//    
//    for(Movie m : listaFilmes) {
//      System.out.println(m.getName());
//      System.out.println(m.getDescription());
//      System.out.println(m.getDuration());
//    }
//

//    MovieController mc = new MovieController();
//    

    // Atualizar filme
//    try {
//      mc.updateMovie(1, "edited", "Comédia", "Filme de comédia", 120, true, 12);
//      System.out.println("Filme editado com sucesso");
//    } catch (Exception ex) {
//      System.out.println(ex.getMessage());
//    }

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

//      PersonController pc = new PersonController(); 
//      Date birth = new Date(1997, 9, 18);
//      try {
//        pc.create("Elieudo Maia", "elieudo.maia@gmail.com", "123", "88998758585", "Em casa", birth);
//      } catch (Exception ex) {
//        System.out.println(ex.getMessage());
//      }

//    MoviePersonController mpc = new MoviePersonController();
//    
//    // assitir filme
//    try {
//      mpc.setWatchedMovie(1, 1, 20);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }

//      List<Movie> movies = mpc.getWatchedFilms(1);
//      for(Movie m : movies) {
//        System.out.println(m.getName());
//        System.out.println(m.getDescription());
//        System.out.println(m.getDuration());
//      }

//    PersonController pc = new PersonController();
//    
//    try {
//      // pegar cliente pelo id
//      Person p = pc.getById(1);
//      System.out.println(p.getName());
//    } catch (Exception ex) {
//      System.out.println(ex.getMessage());
//    }

//      try {
//        List<Person> peopleList = pc.listAll();
//        for (Person p : peopleList) {
//          System.out.println("Nome: " + p.getName());
//        }
//      } catch (Exception e) {
//      }
  }
}
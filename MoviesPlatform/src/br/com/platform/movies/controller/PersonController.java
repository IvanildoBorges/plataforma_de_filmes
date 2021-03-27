/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.controller;

import br.com.platform.movies.model.Administrator;
import br.com.platform.movies.model.Person;
import br.com.platform.movies.model.dao.PersonDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author elieu
 */
public class PersonController {
  private PersonDAO personDAO;

  public PersonController() {
    this.personDAO = new PersonDAO();
  }
  
  public void listAll() {}
  
  public void getById() {}
  
  public void create(String name, String email, String password, String telephone, String address, Date birthDate) throws Exception {
    // TODO - Verificar se quem quer criar o usuário tem permissão de Admin
    
    Person client = new Administrator();
    client.setName(name);
    client.setEmail(email);
    client.setPassword(password);
    client.setTelephone(telephone);
    client.setAddress(address);
    client.setBirthDate(birthDate);
    
    this.personDAO.createPerson(client, true);
  }
  
  public void update() {}
  
  public void delete() {}
  
}

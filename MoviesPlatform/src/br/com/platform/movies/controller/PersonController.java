package br.com.platform.movies.controller;

import br.com.platform.movies.model.Administrator;
import br.com.platform.movies.model.Client;
import br.com.platform.movies.model.Person;
import br.com.platform.movies.model.dao.PersonDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class PersonController {
  private PersonDAO personDAO;

  public PersonController() {
    this.personDAO = new PersonDAO();
  }
  
  public List<Person> listAll() {
    return this.personDAO.listAll();
  }
  
  public Person getById(int personId) throws Exception{
    Person person = this.personDAO.getById(personId);
    return person;
  }
  
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
  
  public void update(int id, String name, String email, String password, String telephone, String address, boolean isAdmin, Date birthDate) {
    Person person = new Client();
    if (isAdmin) person = new Administrator();
    
    person.setId(id);
    person.setName(name);
    person.setEmail(email);
    person.setPassword(password);
    person.setTelephone(telephone);
    person.setAddress(address);
    person.setBirthDate(birthDate);
    
    this.personDAO.updatePerson(person);
  }
  
  public void delete() {
      
  }
  
  public int login(String email, String password) throws Exception {
    Person person = this.personDAO.login(email, password);
    return person.getId();
  }
  
  public boolean checkIsAdmin(int personId) throws Exception {
    return this.personDAO.checkIsAdmin(personId);
  }
}
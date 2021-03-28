package br.com.platform.movies.model;

import java.sql.Date;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public abstract class Person extends User {
  private int id;
  private String name;
  private String telephone;
  private String address;
  private Date birthDate;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.model;

/**
 *
 * @author elieu
 */
public abstract class Person extends User {
  private String name;
  private String telephone;
  private String address;
  private String birthDate;

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

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }
}

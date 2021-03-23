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
public class Movie {
  private String name;
  private String genre;
  private String description;
  private String duration;
  private boolean isAvaiable;
  private String ageRange;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public boolean isIsAvaiable() {
    return isAvaiable;
  }

  public void setIsAvaiable(boolean isAvaiable) {
    this.isAvaiable = isAvaiable;
  }

  public String getAgeRange() {
    return ageRange;
  }

  public void setAgeRange(String ageRange) {
    this.ageRange = ageRange;
  }
}

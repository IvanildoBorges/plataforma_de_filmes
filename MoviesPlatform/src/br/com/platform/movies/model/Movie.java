package br.com.platform.movies.model;

import com.sun.org.glassfish.gmbal.Description;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class Movie {
  private String name;
  private String genre;
  private String description;
  private int duration;
  private boolean isAvaiable;
  private int ageRange;
  
  public Movie () {} 
  
  public Movie(String name, String genre, String description, int duration, boolean isAvailable, int ageRange) {
    this.name = name;
    this.genre = genre;
    this.description = description;
    this.duration = duration;
    this.isAvaiable = isAvailable;
    this.ageRange = ageRange;
  }

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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public boolean isIsAvaiable() {
    return isAvaiable;
  }

  public void setIsAvaiable(boolean isAvaiable) {
    this.isAvaiable = isAvaiable;
  }

  public int getAgeRange() {
    return ageRange;
  }

  public void setAgeRange(int ageRange) {
    this.ageRange = ageRange;
  }
}
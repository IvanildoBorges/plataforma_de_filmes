/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.platform.movies.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author elieu
 */
public class PersonalStatisticsDTO {
  private int totalMinutesWatchedByUser = 0;
  public Map<String, Integer> mapTotalByGenre = new HashMap<>();
  private float overallAverage = 0;
  private float userAverage = 0;

  public int getTotalMinutesWatchedByUser() {
    return totalMinutesWatchedByUser;
  }

  public void setTotalMinutesWatchedByUser(int totalMinutesWatched) {
    this.totalMinutesWatchedByUser = totalMinutesWatched;
  }

  public float getOverallAverage() {
    return overallAverage;
  }

  public void setOverallAverage(float overallAverage) {
    this.overallAverage = overallAverage;
  }

  public float getUserAverage() {
    return userAverage;
  }

  public void setUserAverage(float userAverage) {
    this.userAverage = userAverage;
  }

  public Map<String, Integer> getMapTotalByGenre() {
    return mapTotalByGenre;
  }

  public void setMapTotalByGenre(Map<String, Integer> mapTotalByGenre) {
    this.mapTotalByGenre = mapTotalByGenre;
  }
  
}

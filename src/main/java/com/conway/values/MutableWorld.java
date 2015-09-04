package com.conway.values;

public class MutableWorld extends World {
  public void set(Coordinates coordinates, Contents contents) {
    population.put(coordinates, contents);
  }
  
  public Contents at(Coordinates coordinates) {
    if(population.containsKey(coordinates)) {
      return population.get(coordinates);
    } else {
      return new Nothing();
    }
  }
}

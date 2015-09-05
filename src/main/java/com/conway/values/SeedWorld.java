package com.conway.values;

public class SeedWorld extends World {
  public Contents at(Coordinates coordinates) {
    if(population.containsKey(coordinates)) {
      return population.get(coordinates);
    } else {
      Contents contents = Math.random() <= 0.30 ? new Cell() : new Nothing();
      population.put(coordinates, contents);
      return contents;
    }
  }
}

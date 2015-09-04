package com.conway;

import com.conway.values.Contents;
import com.conway.values.Coordinates;
import com.conway.values.Nothing;
import com.conway.values.World;

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

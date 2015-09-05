package com.conway.values;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class World {  
  protected Map<Coordinates, Contents> population = new HashMap<Coordinates, Contents>();
  
  public abstract Contents at(Coordinates coordinates);

  public Collection<Coordinates> allCoordinates() {
    return population.keySet();
  }
  
}

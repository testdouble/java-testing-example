package com.conway.values;

import java.util.HashMap;
import java.util.Map;

public abstract class World {  
  protected Map<Coordinates, Contents> population = new HashMap<Coordinates, Contents>();
  
  public abstract Contents at(Coordinates coordinates);
  
}

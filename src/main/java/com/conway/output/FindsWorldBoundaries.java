package com.conway.output;

import java.util.Collection;
import static com.conway.util.Functional.*;

import com.conway.values.Boundaries;
import com.conway.values.Coordinates;
import com.conway.values.World;

public class FindsWorldBoundaries {

  public Boundaries find(World world) {
    Collection<Coordinates> coords = world.allCoordinates();
    
    return new Boundaries(      
      min(coords, (c1,c2) -> c1.x.compareTo(c2.x)).x,
      max(coords, (c1,c2) -> c1.x.compareTo(c2.x)).x,
      min(coords, (c1,c2) -> c1.y.compareTo(c2.y)).y,
      max(coords, (c1,c2) -> c1.y.compareTo(c2.y)).y
    );
  }

}

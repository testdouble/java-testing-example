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
      min(map(coords, (c) -> c.x), (x1,x2) -> x1.compareTo(x2)),
      max(map(coords, (c) -> c.x), (x1,x2) -> x1.compareTo(x2)),
      min(map(coords, (c) -> c.y), (y1,y2) -> y1.compareTo(y2)),
      max(map(coords, (c) -> c.y), (y1,y2) -> y1.compareTo(y2))
    );
  }

}

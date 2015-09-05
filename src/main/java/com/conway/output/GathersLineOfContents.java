package com.conway.output;

import java.util.ArrayList;
import java.util.List;

import com.conway.values.Contents;
import com.conway.values.Coordinates;
import com.conway.values.World;

public class GathersLineOfContents {

  public List<Contents> gather(World world, int minX, int maxX, int y) {
    ArrayList<Contents> line = new ArrayList<Contents>();
    for(int x=minX;x <= maxX;x++) {
      line.add(world.at(new Coordinates(x, y)));
    }
    return line;
  }
}

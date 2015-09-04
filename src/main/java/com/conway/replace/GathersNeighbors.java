package com.conway.replace;

import java.util.Arrays;
import java.util.Collection;

import com.conway.values.Coordinates;
import com.conway.values.Point;
import com.conway.values.World;

public class GathersNeighbors {

  public Collection<Point> gather(World world, Coordinates coordinates) {
    return Arrays.asList(
        new Point(world.at(coordinates.topLeft()), coordinates.topLeft()),
        new Point(world.at(coordinates.topCenter()), coordinates.topCenter()),
        new Point(world.at(coordinates.topRight()), coordinates.topRight()),
        new Point(world.at(coordinates.middleLeft()), coordinates.middleLeft()),
        new Point(world.at(coordinates.middleRight()), coordinates.middleRight()),
        new Point(world.at(coordinates.bottomLeft()), coordinates.bottomLeft()),
        new Point(world.at(coordinates.bottomCenter()), coordinates.bottomCenter()),
        new Point(world.at(coordinates.bottomRight()), coordinates.bottomRight())
    );
  }

}

package com.conway.replace;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import com.conway.values.Cell;
import com.conway.values.Contents;
import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;
import com.conway.values.Point;

public class GathersNeighborsTest {

  GathersNeighbors subject = new GathersNeighbors();

  @Test
  public void testWithFullNeighborSet() {
    MutableWorld world = new MutableWorld();
    Contents topLeft = new Cell();
    world.set(new Coordinates(-1,1), topLeft);
    Contents topCenter = new Cell();
    world.set(new Coordinates(0,1), topCenter);
    Contents topRight = new Cell();
    world.set(new Coordinates(1,1), topRight);
    Contents middleLeft = new Cell();
    world.set(new Coordinates(-1,0), middleLeft);
    Contents middleCenter = new Cell();
    world.set(new Coordinates(0,0), middleCenter);
    Contents middleRight = new Cell();
    world.set(new Coordinates(1,0), middleRight);
    Contents bottomLeft = new Cell();
    world.set(new Coordinates(-1,-1), bottomLeft);
    Contents bottomCenter = new Cell();
    world.set(new Coordinates(0,-1), bottomCenter);
    Contents bottomRight = new Cell();
    world.set(new Coordinates(1,-1), bottomRight);
    
    Collection<Point> result = subject.gather(world, new Coordinates(0,0));
    
    assertThat(result.size(), is(8));
    assertThat(result, contains(
        pointAt(topLeft,-1,1),pointAt(topCenter,0,1),pointAt(topRight,1,1),
        pointAt(middleLeft,-1,0), /*No origin!,*/ pointAt(middleRight,1,0),
        pointAt(bottomLeft,-1,-1), pointAt(bottomCenter,0,-1), pointAt(bottomRight,1,-1)));
    assertThat(result, not(contains(pointAt(middleCenter,0,0)))); 
  }
  
  private Point pointAt(Contents contents,int x,int y) {
    return new Point(contents, new Coordinates(x,y));
  }
}
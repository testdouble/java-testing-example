package com.conway.output;

import org.junit.*;

import com.conway.values.Boundaries;
import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class FindsWorldBoundariesTest {

  FindsWorldBoundaries subject = new FindsWorldBoundaries();

  @Test
  public void singlePlotTest() {
    MutableWorld world = new MutableWorld();
    world.set(new Coordinates(-5,3), null);
    
    Boundaries result = subject.find(world);
    
    assertThat(result.minX, is(-5));
    assertThat(result.maxX, is(-5));
    assertThat(result.minY, is(3));
    assertThat(result.maxY, is(3));
  }
  
  @Test
  public void twoPlotTest() {
    MutableWorld world = new MutableWorld();
    world.set(new Coordinates(-13,84), null);
    world.set(new Coordinates(19,-12), null);
    
    Boundaries result = subject.find(world);
    
    assertThat(result.minX, is(-13));
    assertThat(result.maxX, is(19));
    assertThat(result.minY, is(-12));
    assertThat(result.maxY, is(84));
  }
}
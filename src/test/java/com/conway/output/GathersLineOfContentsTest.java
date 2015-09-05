package com.conway.output;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.conway.values.Contents;
import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;
import com.conway.values.Nothing;

public class GathersLineOfContentsTest {

  GathersLineOfContents subject = new GathersLineOfContents();

  @Test
  public void test() {
    MutableWorld world = new MutableWorld();
    int minX = 3;
    int maxX = 5;
    int y = 5;
    Contents contents1 = new Contents();
    world.set(new Coordinates(minX,y), contents1);
    Contents contents2 = new Contents();
    world.set(new Coordinates(minX+1,y), contents2);
    Contents contents3 = new Contents();
    world.set(new Coordinates(maxX,y), contents3);
    
    List<Contents> result = subject.gather(world, minX, maxX, y);
    
    assertThat(result, contains(contents1,contents2,contents3));
  }
  
  @Test
  public void skipItemsNotInTheLine() {
    MutableWorld world = new MutableWorld();
    Contents skipMe = new Contents();
    world.set(new Coordinates(5,8), skipMe);
    
    List<Contents> result = subject.gather(world, 4, 6, 9);
    
    assertThat(result, not(contains(skipMe)));
  }
  
  @Test
  public void missedItemsAreNothings() {
    MutableWorld world = new MutableWorld();
    
    List<Contents> result = subject.gather(world, 0, 4, 0);
    
    assertThat(result.size(), is(5));
    assertThat(result.get(0), is(instanceOf(Nothing.class)));
    assertThat(result.get(1), is(instanceOf(Nothing.class)));
    assertThat(result.get(2), is(instanceOf(Nothing.class)));
    assertThat(result.get(3), is(instanceOf(Nothing.class)));
    assertThat(result.get(4), is(instanceOf(Nothing.class)));
  }
}
package com.conway.replace;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conway.values.Contents;
import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;
import com.conway.values.Outcome;
import com.conway.values.Point;
import com.conway.values.World;

@RunWith(MockitoJUnitRunner.class)
public class ReplacesCellTest {

  @InjectMocks
  ReplacesCell subject;
  
  @Mock GathersNeighbors gathersNeighbors;
  @Mock DeterminesNextContents determinesNextContents; 

  @Test
  public void test() {
    World world = new MutableWorld();
    Coordinates coordinates = new Coordinates(42,1337);
    Collection<Point> neighbors = new ArrayList<Point>();
    when(gathersNeighbors.gather(world, coordinates)).thenReturn(neighbors);
    Contents nextContents = new Contents();
    when(determinesNextContents.determine(neighbors)).thenReturn(nextContents);
    
    Outcome outcome = subject.replace(world, coordinates);
    
    assertThat(outcome.neighbors, is(neighbors));
    assertThat(outcome.nextContents, is(nextContents));
  }
}
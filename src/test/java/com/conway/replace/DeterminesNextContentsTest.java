package com.conway.replace;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.conway.values.Cell;
import com.conway.values.Contents;
import com.conway.values.Nothing;
import com.conway.values.Point;

public class DeterminesNextContentsTest {

  DeterminesNextContents subject = new DeterminesNextContents();

  @Test
  public void testZeroCells() {
    Collection<Point> neighbors = neighbors(0);
    
    Contents result = subject.determine(new Cell(), neighbors);
    
    assertThat(result, instanceOf(Nothing.class));
  }
  
  @Test
  public void testOneCells() {
    Collection<Point> neighbors = neighbors(1);
    
    Contents result = subject.determine(new Cell(), neighbors);
    
    assertThat(result, instanceOf(Nothing.class));
  }
  
  @Test
  public void testTwoCells() {
    Collection<Point> neighbors = neighbors(2);
    
    Contents result = subject.determine(new Cell(), neighbors);
    
    assertThat(result, instanceOf(Cell.class));
  }
  
  //Make a list of neighbors with n cells and 9 - n non-cells.
  private Collection<Point> neighbors(int cellCount) {
    ArrayList<Point> neighbors = new ArrayList<Point>();
    for(int i=0;i<9;i++) {
      neighbors.add(new Point(i<cellCount ? new Cell() : new Nothing(),null));
    }
    return neighbors;
  }
}
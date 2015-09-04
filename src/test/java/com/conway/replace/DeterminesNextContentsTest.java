package com.conway.replace;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.conway.values.Cell;
import com.conway.values.Nothing;
import com.conway.values.Point;

public class DeterminesNextContentsTest {

  DeterminesNextContents subject = new DeterminesNextContents();

  @Test
  public void testAllTheNothingCases() {
    assertThat(subject.determine(new Nothing(), neighbors(0)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(1)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(2)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(3)), instanceOf(Cell.class));
    assertThat(subject.determine(new Nothing(), neighbors(4)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(5)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(6)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(7)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Nothing(), neighbors(8)), instanceOf(Nothing.class));    
  }
  
  @Test
  public void testAllTheCellCases() {
    assertThat(subject.determine(new Cell(), neighbors(0)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Cell(), neighbors(1)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Cell(), neighbors(2)), instanceOf(Cell.class));
    assertThat(subject.determine(new Cell(), neighbors(3)), instanceOf(Cell.class));
    assertThat(subject.determine(new Cell(), neighbors(4)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Cell(), neighbors(5)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Cell(), neighbors(6)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Cell(), neighbors(7)), instanceOf(Nothing.class));
    assertThat(subject.determine(new Cell(), neighbors(8)), instanceOf(Nothing.class));
    
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
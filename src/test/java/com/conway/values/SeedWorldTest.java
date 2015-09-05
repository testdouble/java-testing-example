package com.conway.values;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SeedWorldTest {

  @Test
  public void ensureAbout30PercentOfCellsAreRandom() {
    int cells = 0;
    for(int i=0;i<1000;i++) {
      Contents contents = new SeedWorld().at(new Coordinates(42,12));
      if(contents instanceof Cell) {
        cells++;
      }
    }

    // Will fail sometimes, but not often. Yay testing random!
    assertThat(cells, both(greaterThan(200)).and(lessThan(400)));
  }
  
  @Test
  public void onceSetAlwaysSet() {
    SeedWorld subject = new SeedWorld();
    
    Contents first = subject.at(new Coordinates(55,64));
    Contents second = subject.at(new Coordinates(55,64));
    
    assertThat(first, is(second));
  }
  
}

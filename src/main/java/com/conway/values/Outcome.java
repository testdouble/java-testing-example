package com.conway.values;

import java.util.Collection;

public class Outcome {
  public Contents nextContents;
  public Collection<Point> neighbors;
  
  public Outcome(Contents nextContents, Collection<Point> neighbors) {
    this.nextContents = nextContents;
    this.neighbors = neighbors;
  }

}

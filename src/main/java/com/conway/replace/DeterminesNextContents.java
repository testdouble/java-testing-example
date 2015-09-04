package com.conway.replace;

import java.util.Collection;

import com.conway.util.Functional;
import com.conway.values.Cell;
import com.conway.values.Contents;
import com.conway.values.Nothing;
import com.conway.values.Point;

public class DeterminesNextContents {

  public Contents determine(Contents currentContents, Collection<Point> neighbors) {
    switch(Functional.filter(neighbors, p -> p.contents instanceof Cell).size()) {
      case 2:
        return currentContents;
      case 3:
        return new Cell();
      default:
        return new Nothing(); 
    }
  }
}

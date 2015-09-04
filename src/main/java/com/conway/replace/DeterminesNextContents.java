package com.conway.replace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.conway.values.Cell;
import com.conway.values.Contents;
import com.conway.values.Nothing;
import com.conway.values.Point;

public class DeterminesNextContents {

  public Contents determine(Contents currentContents, Collection<Point> neighbors) {
    switch(filter(neighbors, p -> p.contents instanceof Cell).size()) {
      case 2:
        return currentContents;
      default:
        return new Nothing(); 
    }
  }

  private <T> Collection<T> filter(Collection<T> collection, Predicate<? super T> predicate) {
    return collection.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
  }

}

package com.conway.util;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Functional {

  public static <T> Collection<T> filter(Collection<T> collection, Predicate<? super T> predicate) {
    return collection.stream().filter(predicate).collect(Collectors.toList());
  }

}

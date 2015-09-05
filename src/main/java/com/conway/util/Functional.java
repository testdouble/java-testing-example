package com.conway.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Functional {

  public static <T> Collection<T> filter(Collection<T> collection, Predicate<? super T> predicate) {
    return collection.stream().filter(predicate).collect(Collectors.toList());
  }
  
  public static <T,R> Collection<R> map(Collection<T> collection, Function<? super T, ? extends R> predicate) {
    return collection.stream().map(predicate).collect(Collectors.toList());
  }
  
  public static <T> T min(Collection<T> collection, Comparator<? super T> comparator) {
    return collection.stream().min(comparator).get();
  }
  
  public static <T> T max(Collection<T> collection, Comparator<? super T> comparator) {
    return collection.stream().max(comparator).get();
  }

}

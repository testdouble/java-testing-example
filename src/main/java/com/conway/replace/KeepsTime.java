package com.conway.replace;

import com.conway.values.TimeLimit;

public class KeepsTime {

  public TimeLimit keep(int limitInMilliseconds) {
    return new TimeLimit(limitInMilliseconds);
  }

}

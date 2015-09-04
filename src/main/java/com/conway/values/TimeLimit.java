package com.conway.values;

import java.util.Date;

public class TimeLimit {

  private long limitInMilliseconds;
  private long startTime;

  public TimeLimit(long limitInMilliseconds) {
    this.limitInMilliseconds = limitInMilliseconds;
    this.startTime = new Date().getTime();
  }

  public boolean isTimeUp() {
    long elapsed = new Date().getTime() - startTime;
    return elapsed > limitInMilliseconds;
  }

}

package com.conway.values;

import java.util.Date;

public class TimeLimit {

  public long limitInMilliseconds;
  public long startTime;

  public TimeLimit(long limitInMilliseconds) {
    this.limitInMilliseconds = limitInMilliseconds;
    this.startTime = new Date().getTime();
  }

  public boolean isTimeUp() {
    long elapsed = new Date().getTime() - startTime;
    return elapsed > limitInMilliseconds;
  }

}

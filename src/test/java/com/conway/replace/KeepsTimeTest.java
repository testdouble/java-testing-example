package com.conway.replace;

import org.junit.*;

import com.conway.values.TimeLimit;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class KeepsTimeTest {

  KeepsTime subject = new KeepsTime();

  @Test
  public void test() {
    TimeLimit result = subject.keep(55);
    
    assertThat(result.limitInMilliseconds, is(55l));
  }
}
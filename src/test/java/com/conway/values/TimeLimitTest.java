package com.conway.values;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TimeLimitTest {

  @Test
  public void testBasicTimeLimit() throws InterruptedException {
    TimeLimit subject = new TimeLimit(20);
    
    assertThat(subject.isTimeUp(), is(false));
    Thread.sleep(21);
    assertThat(subject.isTimeUp(), is(true));
  }
  
}

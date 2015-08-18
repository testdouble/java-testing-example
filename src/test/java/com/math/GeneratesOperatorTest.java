package com.math;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GeneratesOperatorTest {

  GeneratesOperator subject = new GeneratesOperator();

  @Test
  public void test() {    
    String result = subject.generate();
    
    assertThat(result , anyOf(is("-"), is("+"), is("/"), is("*")));    
  }
}
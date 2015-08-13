package com.acme.app;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class HelloWorldTest {

  HelloWorld subject = new HelloWorld();

  @Test
  public void test() {
    String result = subject.say();

    assertThat(result, is("Hello, World."));
  }
}
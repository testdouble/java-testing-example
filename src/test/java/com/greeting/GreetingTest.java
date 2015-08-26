package com.greeting;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class GreetingTest {

  Greeting subject = new Greeting();

  @Test
  public void returnsBob() {
    String result = subject.greet("Bob");

    assertThat(result, is("Hello, Bob."));
  }

  @Test
  public void returnsBasicName() {
    String result = subject.greet("Lisa");

    assertThat(result, is("Hello, Lisa."));
  }

  @Test
  public void givesStandInForNullNames() {
    String result = subject.greet(null);

    assertThat(result, is("Hello, my friend."));
  }
  
  @Test
  public void shoutsBackAtUppercaseNames() {
    String result = subject.greet("JERRY");

    assertThat(result, is("HELLO JERRY!"));
  }
  
  @Test
  public void greetsTwoNames() {
    String result = subject.greet("Jill", "Jane");

    assertThat(result, is("Hello, Jill and Jane."));    
  }
  
  @Test
  public void shoutsTwoNames() {
    String result = subject.greet("JERRY", "JACK");

    assertThat(result, is("HELLO JERRY AND JACK!"));
  }
  
  @Test
  public void greetsThreeNames() {
    String result = subject.greet("Amy", "Brian", "Charlotte");
        
    assertThat(result, is("Hello, Amy, Brian, and Charlotte."));
  }
  
  @Test @Ignore
  public void itSegregatesShoutingAndNonShouting() {
    String result = subject.greet("Amy", "BRIAN", "Charlotte");
    
    assertThat(result, is("Hello, Amy and Charlotte. AND HELLO BRIAN!"));
  }

}
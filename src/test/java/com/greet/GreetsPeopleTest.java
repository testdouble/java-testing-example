package com.greet;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class GreetsPeopleTest {

  GreetsPeople subject = new GreetsPeople();

  @Test
  public void greetsOnePerson() {
    String result = subject.greet("Bob");

    assertThat(result, is("Hello, Bob."));
  }

  @Test
  public void greetsAnotherPerson() {
    String result = subject.greet("Jill");

    assertThat(result, is("Hello, Jill."));
  }

  @Test
  public void greetsNullPeople() {
    String result = subject.greet((String)null);

    assertThat(result, is("Hello, my friend."));
  }
  
  @Test
  public void shoutsAtShoutingPeople() {
    String result = subject.greet("RAJ");
    
    assertThat(result, is("HELLO RAJ!"));
  }
  
  @Test
  public void testVarArgsEdgeCases() {
    assertThat(subject.greet(), is("Hello, my friend."));
    assertThat(subject.greet((String) null), is("Hello, my friend."));
    assertThat(subject.greet(new String[] {null}), is("Hello, my friend."));
  }
  
  @Test
  public void greetsTwoPeople() {
    String result = subject.greet("Niju", "Ryan");
    
    assertThat(result, is("Hello, Niju and Ryan.")); 
  }
  
  @Test
  public void greetsThreePeople() {
    String result = subject.greet("Pradeep", "Roy", "Yam");
    
    assertThat(result, is("Hello, Pradeep, Roy, and Yam.")); 
  }
  
  @Test
  public void shoutsAtThreePeople() {
    String result = subject.greet("PRADEEP", "ROY", "YAM");
    
    assertThat(result, is("HELLO PRADEEP, ROY, AND YAM!")); 
  }
  
  @Test
  public void greetsFourPeople() {
    String result = subject.greet("Pradeep", "Roy", "Yam", "Qin");
    
    assertThat(result, is("Hello, Pradeep, Roy, Yam, and Qin.")); 
  }
  
  
  
  
  
  
  
  
  
  
  

}
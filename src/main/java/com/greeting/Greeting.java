package com.greeting;

import java.util.Arrays;
import java.util.List;

public class Greeting {

  public String greet(String... names) {
    if (names == null || names.length == 0) { return "Hello, my friend."; }    
    StringBuilder sb = new StringBuilder();    
    if(shouting(names[0])) {
      sb.append(shoutsNames(names));
    } else {
      sb.append(saysNames(names));
    }    
    return sb.toString();
  }
  
  private String shoutsNames(String[] names) {
    StringBuilder sb = new StringBuilder();
    sb.append("HELLO ");
    sb.append(listNames(names).toUpperCase());
    sb.append("!");
    return sb.toString();
  }
  
  private String saysNames(String[] names) {
    StringBuilder sb = new StringBuilder();
    sb.append("Hello, ");
    sb.append(listNames(names));
    sb.append('.');  
    return sb.toString();
  }
  
  private String listNames(String[] names) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < names.length; i++) {        
      sb.append(listFormattingFor(i, names.length));
      sb.append(names[i]);
    }
    return sb.toString();
  }
  
  private String listFormattingFor(int position, int length) {
    if(position == 0) { return ""; }
    if(length == 2 && position == 1) { return " and "; }
    if(position == length - 1) { return ", and "; } 
    return ", ";
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  private boolean shouting(String name) {
    return name.equals(name.toUpperCase());
  }

}

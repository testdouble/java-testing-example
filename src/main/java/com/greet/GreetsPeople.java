package com.greet;

public class GreetsPeople {

  public String greet(String... names) {
    if (isBlank(names)) {
      return "Hello, my friend.";
    }

    String name = names[0];
    StringBuilder sb = new StringBuilder();
    if (name.toUpperCase() != name) {
      sb.append("Hello,").append(listNames(names)).append(".");
    } else {
      sb.append("HELLO").append(listNames(names).toUpperCase()).append("!");
    }

    return sb.toString();
  }

  private boolean isBlank(String[] input) {
    return input == null || input.length == 0 || input[0] == null;
  }

  private String listNames(String[] names) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < names.length; i++) {
      if (names.length != 2 && i != 0) {
        sb.append(",");
      }
      if (names.length > 1 && i == names.length - 1) {
        sb.append(" and");
      }
      sb.append(" ").append(names[i]);
    }
    return sb.toString();
  }
  
}

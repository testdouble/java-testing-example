package com.math;

import java.util.Random;

public class GeneratesOperator {
  
  public String generate() {
    return new String[]{"+", "-", "*", "/"}[new Random().nextInt(4)];
  }

}

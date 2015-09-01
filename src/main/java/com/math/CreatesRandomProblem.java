package com.math;

public class CreatesRandomProblem {

  GivesRandomOperand givesRandomOperand = new GivesRandomOperand();
  GivesRandomOperator givesRandomOperator = new GivesRandomOperator();
  
  public Problem create() {
    return new Problem(
        givesRandomOperand.give(),
        givesRandomOperand.give(),
        givesRandomOperator.give());
  }

}

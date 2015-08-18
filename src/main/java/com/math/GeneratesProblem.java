package com.math;

public class GeneratesProblem {
  
  private GeneratesOperator generatesOperator;
  private GeneratesOperand generatesOperand;

  public Problem generate() {
    Problem problem = new Problem();
    problem.operator = generatesOperator.generate();
    problem.leftOperand = generatesOperand.generate();
    problem.rightOperand = generatesOperand.generate();
    return problem;
  }

}

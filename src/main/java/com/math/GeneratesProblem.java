package com.math;

public class GeneratesProblem {

  CreatesRandomProblem createsRandomProblem = new CreatesRandomProblem();
  SavesProblem savesProblem = new SavesProblem();
  PresentsProblem presentsProblem = new PresentsProblem();
  
  public Problem generate() {
    return presentsProblem.present(
        savesProblem.save(
            createsRandomProblem.create()
    ));    
  }

}

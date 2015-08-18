package com.math;

public class GetsProblem {

  private GeneratesProblem generatesProblem;
  private SavesProblem savesProblem;
  private SerializesProblem serializesProblem;
  
  public SerializedProblem get() {    
    return serializesProblem.serialize(
        savesProblem.save(
            generatesProblem.generate()));
  }

}

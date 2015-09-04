package com.conway;

public class SimulatesConway {

  GeneratesSeedWorld generatesSeedWorld = new GeneratesSeedWorld();
  OutputsWorld outputsWorld = new OutputsWorld();
  ReplacesWorld replacesWorld = new ReplacesWorld();
  
  public void simulate(int iterations) {
    World world = generatesSeedWorld.generate();
    for(int i=0; i < iterations; i++) {
      outputsWorld.output(world);
      world = replacesWorld.replace(world);
    }
  }

}

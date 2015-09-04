package com.conway;

import java.util.ArrayList;
import java.util.Collection;

import com.conway.values.Coordinates;
import com.conway.values.Outcome;
import com.conway.values.Point;
import com.conway.values.TimeLimit;
import com.conway.values.World;

public class ReplacesWorld {

  KeepsTime keepsTime;
  ReplacesCell replacesCell;
  
  public World replace(World oldWorld, int timeLimitInMs) {
    MutableWorld newWorld = new MutableWorld();
    TimeLimit timeLimit = keepsTime.keep(timeLimitInMs);
    
    Coordinates coordinates = new Coordinates(0, 0);    
    
    while(timeLimit.isTimeUp() == false) {
      Outcome outcome = replacesCell.replace(oldWorld, coordinates);
      newWorld.set(coordinates, outcome.nextContents);
      
    }
    return newWorld;
  }

}

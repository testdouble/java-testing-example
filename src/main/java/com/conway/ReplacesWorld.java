package com.conway;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;
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
    Queue<Point> pointsToProcess = new LinkedList<Point>(Arrays.asList(origin(oldWorld)));
    while (!pointsToProcess.isEmpty() && !timeLimit.isTimeUp()) {
      Point point = pointsToProcess.remove();
      Outcome outcome = replacesCell.replace(oldWorld, point.coordinates);
      pointsToProcess.addAll(outcome.neighbors);
      newWorld.set(point.coordinates, outcome.nextContents);
    }
    return newWorld;
  }

  private Point origin(World world) {
    return new Point(world.at(new Coordinates(0, 0)), new Coordinates(0, 0));
  }

}

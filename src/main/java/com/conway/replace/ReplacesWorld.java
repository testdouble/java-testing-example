package com.conway.replace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.conway.util.Functional.*;
import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;
import com.conway.values.Outcome;
import com.conway.values.Point;
import com.conway.values.TimeLimit;
import com.conway.values.World;

public class ReplacesWorld {

  KeepsTime keepsTime = new KeepsTime();
  ReplacesCell replacesCell = new ReplacesCell();

  public World replace(World oldWorld, int timeLimitInMs) {
    MutableWorld newWorld = new MutableWorld();
    TimeLimit timeLimit = keepsTime.keep(timeLimitInMs);
    Queue<Point> pointsToProcess = new LinkedList<Point>(Arrays.asList(origin(oldWorld)));
    while (!pointsToProcess.isEmpty() && !timeLimit.isTimeUp()) {
      Point point = pointsToProcess.remove();
      Outcome outcome = replacesCell.replace(oldWorld, point.coordinates);
      newWorld.set(point.coordinates, outcome.nextContents);
      pointsToProcess.addAll(filter(outcome.neighbors, p -> newWorld.notYetSet(p.coordinates)));
    }
    return newWorld;
  }

  private Point origin(World world) {
    return new Point(world.at(new Coordinates(0, 0)), new Coordinates(0, 0));
  }

}

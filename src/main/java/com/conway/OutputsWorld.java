package com.conway;

import com.conway.output.FindsWorldBoundaries;
import com.conway.output.GathersLineOfContents;
import com.conway.output.PrintsLine;
import com.conway.values.Boundaries;
import com.conway.values.World;

public class OutputsWorld {

  FindsWorldBoundaries findsWorldBoundaries = new FindsWorldBoundaries();
  GathersLineOfContents gathersLineOfContents = new GathersLineOfContents();
  PrintsLine printsLine = new PrintsLine();
  
  public void output(World world) {
    Boundaries boundaries = findsWorldBoundaries.find(world);
    for(int y=boundaries.maxY;y >= boundaries.minY;y--) {
      printsLine.print(
          gathersLineOfContents.gather(
              world, y, boundaries.minX, boundaries.maxX));
    }
  }

}

package com.conway;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conway.output.FindsWorldBoundaries;
import com.conway.output.GathersLineOfContents;
import com.conway.output.PrintsLine;
import com.conway.values.Boundaries;
import com.conway.values.Contents;
import com.conway.values.MutableWorld;
import com.conway.values.World;

@RunWith(MockitoJUnitRunner.class)
public class OutputsWorldTest {

  @InjectMocks
  OutputsWorld subject;

  @Mock FindsWorldBoundaries findsWorldBoundaries;
  @Mock GathersLineOfContents gathersLineOfContents;
  @Mock PrintsLine printsLine;
  
  @Test
  public void test() {
    World world = new MutableWorld();
    int minY = 10;
    int maxY = 12;
    Boundaries boundaries = new Boundaries(8,9,minY,maxY);
    when(findsWorldBoundaries.find(world)).thenReturn(boundaries);
    List<Contents> line1 = Arrays.asList(new Contents());
    when(gathersLineOfContents.gather(world, 8, 9, minY)).thenReturn(line1);
    List<Contents> line2 = Arrays.asList(new Contents());
    when(gathersLineOfContents.gather(world, 8, 9, minY + 1)).thenReturn(line2);
    List<Contents> line3 = Arrays.asList(new Contents());
    when(gathersLineOfContents.gather(world, 8, 9, maxY)).thenReturn(line3);

    subject.output(world);
    
    verify(printsLine).print(line1);
    verify(printsLine).print(line2);
    verify(printsLine).print(line3);
  }
}
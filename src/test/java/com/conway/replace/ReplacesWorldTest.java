package com.conway.replace;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conway.values.Cell;
import com.conway.values.Coordinates;
import com.conway.values.MutableWorld;
import com.conway.values.Outcome;
import com.conway.values.Point;
import com.conway.values.TimeLimit;
import com.conway.values.World;

@RunWith(MockitoJUnitRunner.class)
public class ReplacesWorldTest {

  @InjectMocks
  ReplacesWorld subject;
  
  @Mock KeepsTime keepsTime;
  @Mock ReplacesCell replacesCell;
  
  private int SOME_TIME_LIMIT=42;
  
  @Mock TimeLimit timeLimit; //<- not a dependency
  
  @Before
  public void stubTimeLimit() {
    when(keepsTime.keep(SOME_TIME_LIMIT)).thenReturn(timeLimit);
  }
  
  @Test
  public void testOneTickOfTime() {
    World world = new MutableWorld();
    when(timeLimit.isTimeUp()).thenReturn(false, true); //<-- allow one cell replacement
    Outcome outcome = new Outcome(new Cell(), new ArrayList<Point>());
    when(replacesCell.replace(world, new Coordinates(0,0))).thenReturn(outcome);
    
    World result = subject.replace(world, SOME_TIME_LIMIT);
    
    assertThat(result.at(new Coordinates(0,0)), is(outcome.nextContents));
  }
  
  @Test
  public void testTwoTicksOfTime() {
    World world = new MutableWorld();
    when(timeLimit.isTimeUp()).thenReturn(false, false, true); //<-- allow TWO cell replacement
    Outcome firstOutcome = new Outcome(new Cell(), Arrays.asList(new Point(new Cell(), new Coordinates(1,0))));
    when(replacesCell.replace(world, new Coordinates(0,0))).thenReturn(firstOutcome);
    Outcome secondOutcome = new Outcome(new Cell(), new ArrayList<Point>());
    when(replacesCell.replace(world, new Coordinates(1,0))).thenReturn(secondOutcome);
    
    World result = subject.replace(world, SOME_TIME_LIMIT);
    
    assertThat(result.at(new Coordinates(0,0)), is(firstOutcome.nextContents));
    assertThat(result.at(new Coordinates(1,0)), is(secondOutcome.nextContents));
  }
  
  @Test
  public void doesNotCalculateSameCoordinatesTwice() {
    //TODO: Right now the same neighbor will get calculated up to 8 times,
    // we should short-circuit already created ones (flag in the new world?)
  }
}







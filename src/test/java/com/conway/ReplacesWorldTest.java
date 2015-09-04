package com.conway;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conway.values.Cell;
import com.conway.values.Coordinates;
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
  
  @Test
  public void test() {
    World world = new MutableWorld();
    TimeLimit timeLimit = mock(TimeLimit.class);
    when(timeLimit.isTimeUp()).thenReturn(false, true); //<-- allow one cell replacement
    when(keepsTime.keep(42)).thenReturn(timeLimit);
    Coordinates coordinates = new Coordinates(0,0);
    Cell newCell = new Cell();
    Outcome outcome = new Outcome(newCell, new ArrayList<Point>());
    when(replacesCell.replace(world, coordinates)).thenReturn(outcome);
    
    World result = subject.replace(world, 42);
    
    assertThat(result.at(coordinates), is(newCell));
  }
}







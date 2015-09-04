package com.conway;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conway.values.World;

import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class SimulatesConwayTest {

  @InjectMocks
  SimulatesConway subject;

  @Mock
  GeneratesSeedWorld generatesSeedWorld;

  @Mock
  OutputsWorld outputsWorld;

  @Mock
  ReplacesWorld replacesWorld;

  @Test
  public void testOneRound() {
    World seedWorld = new MutableWorld();
    when(generatesSeedWorld.generate()).thenReturn(seedWorld );
    
    subject.simulate(1, 1337);
    
    verify(outputsWorld).output(seedWorld);
  }
  
  @Test
  public void testTwoRounds() {
    int timeLimit = 1337;
    World seedWorld = new MutableWorld();
    when(generatesSeedWorld.generate()).thenReturn(seedWorld );
    World world2 = new MutableWorld();
    when(replacesWorld.replace(seedWorld, timeLimit)).thenReturn(world2);
    
    subject.simulate(2, timeLimit);
    
    verify(outputsWorld).output(seedWorld);
    verify(outputsWorld).output(world2);
  }
}
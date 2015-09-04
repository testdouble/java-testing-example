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
    World seedWorld = new World();
    when(generatesSeedWorld.generate()).thenReturn(seedWorld );
    
    subject.simulate(1);
    
    verify(outputsWorld).output(seedWorld);
  }
  
  @Test
  public void testTwoRounds() {
    World seedWorld = new World();
    when(generatesSeedWorld.generate()).thenReturn(seedWorld );
    World world2 = new World();
    when(replacesWorld.replace(seedWorld)).thenReturn(world2);
    
    subject.simulate(2);
    
    verify(outputsWorld).output(seedWorld);
    verify(outputsWorld).output(world2);
  }
}
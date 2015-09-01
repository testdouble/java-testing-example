package com.math;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GeneratesProblemTest {

  @InjectMocks
  GeneratesProblem subject;

  @Mock
  CreatesRandomProblem createsRandomProblem;
  @Mock
  SavesProblem savesProblem;
  @Mock
  PresentsProblem presentsProblem;

  @Test
  public void test() {
    Problem problem = new Problem(); 
    when(createsRandomProblem.create()).thenReturn(problem);
    Problem savedProblem = new Problem();
    when(savesProblem.save(problem)).thenReturn(savedProblem );
    Problem presentedProblem = new Problem();
    when(presentsProblem.present(savedProblem)).thenReturn(presentedProblem);
    
    Problem result = subject.generate();
    
    assertThat(result, is(presentedProblem));
  }

}
package com.math;

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
public class GetsProblemTest {

  @InjectMocks
  GetsProblem subject;

  @Mock GeneratesProblem generatesProblem;
  @Mock SavesProblem savesProblem;
  @Mock SerializesProblem serializesProblem;
  
  @Test
  public void test() {
    Problem problem = new Problem();
    SavedProblem savedProblem = new SavedProblem(problem);
    SerializedProblem serializedProblem = new SerializedProblem(savedProblem);
    when(generatesProblem.generate()).thenReturn(problem);
    when(savesProblem.save(problem)).thenReturn(savedProblem);
    when(serializesProblem.serialize(savedProblem)).thenReturn(serializedProblem);
    
    SerializedProblem result = subject.get();
    
    assertThat(result, is(serializedProblem));
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
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
public class GeneratesProblemTest {

  @InjectMocks
  GeneratesProblem subject;
  
  @Mock GeneratesOperator generatesOperator;
  @Mock GeneratesOperand generatesOperand;
  
  @Test
  public void test() {
    when(generatesOperator.generate()).thenReturn("SOME OPERATOR");
    when(generatesOperand.generate()).thenReturn(1337, 42);    
    
    Problem result = subject.generate();
    
    assertThat(result.operator, is("SOME OPERATOR"));
    assertThat(result.leftOperand, either(is(1337)).or(is(42)));
    assertThat(result.rightOperand, either(is(1337)).or(is(42)));    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}
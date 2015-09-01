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
public class CreatesRandomProblemTest {

  @InjectMocks
  CreatesRandomProblem subject;
  
  @Mock GivesRandomOperand givesRandomOperand;
  @Mock GivesRandomOperator givesRandomOperator;

  @Test
  public void test() {
    when(givesRandomOperand.give()).thenReturn(1337, -42);
    when(givesRandomOperator.give()).thenReturn("some operator");
    
    Problem result = subject.create();
        
    assertThat(result.leftOperand, isOneOf(1337, -42));
    assertThat(result.rightOperand, isOneOf(1337, -42));
    assertThat(result.leftOperand, is(not(result.rightOperand)));
    assertThat(result.operator, is("some operator"));
  }
}
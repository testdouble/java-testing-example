package com.acme.app;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldProxyTest {

  @InjectMocks HelloWorldProxy subject;

  @Mock HelloWorld helloWorld;
 
  @Test
  public void test() {
    when(helloWorld.say()).thenReturn("Something Cool");
    
    String result = subject.say();
    
    assertThat(result, is("Something Cool"));
  }
}
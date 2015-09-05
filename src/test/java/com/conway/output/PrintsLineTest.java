package com.conway.output;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conway.values.Cell;
import com.conway.values.Contents;
import com.conway.values.Nothing;
import com.conway.wrappers.SystemOutPrintlnWrapper;

@RunWith(MockitoJUnitRunner.class)
public class PrintsLineTest {

  @InjectMocks
  PrintsLine subject;
  
  @Mock
  SystemOutPrintlnWrapper systemOutPrintlnWrapper;

  @Test
  public void empty() {
    List<Contents> line = Arrays.asList();
    
    subject.print(line);
    
    verify(systemOutPrintlnWrapper).println("");
  }
  
  @Test
  public void nothingCellNothing() {
    List<Contents> line = Arrays.asList(
      new Nothing(),
      new Cell(),
      new Nothing()
    );
    
    subject.print(line);
    
    verify(systemOutPrintlnWrapper).println(" * ");
  }
  
  @Test
  public void contentsSuperclassIsUnkown() {
    List<Contents> line = Arrays.asList(new Contents());
    
    subject.print(line);
    
    verify(systemOutPrintlnWrapper).println("?");
  }
}
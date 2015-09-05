package com.conway.output;

import java.util.List;

import com.conway.values.Cell;
import com.conway.values.Contents;
import com.conway.values.Nothing;
import com.conway.wrappers.SystemOutPrintlnWrapper;

public class PrintsLine {
  
  SystemOutPrintlnWrapper systemOutPrintlnWrapper;

  public void print(List<Contents> line) {
    StringBuilder sb = new StringBuilder();
    for(Contents contents : line) {
      if(contents instanceof Cell) {
        sb.append('*');
      } else if(contents instanceof Nothing) {
        sb.append(' ');
      } else {
        sb.append('?');
      }
    }
    systemOutPrintlnWrapper.println(sb.toString());
  }

}

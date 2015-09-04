package com.conway.replace;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.conway.values.Contents;
import com.conway.values.Nothing;
import com.conway.values.Point;

public class DeterminesNextContentsTest {

  DeterminesNextContents subject = new DeterminesNextContents();

  @Test
  public void testZeroCells() {
    Collection<Point> neighbors = new ArrayList<Point>();
    
    Contents result = subject.determine(neighbors);
    
    assertThat(result, instanceOf(Nothing.class));
  }
}
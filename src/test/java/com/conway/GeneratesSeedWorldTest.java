package com.conway;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.conway.values.SeedWorld;
import com.conway.values.World;

public class GeneratesSeedWorldTest {

  GeneratesSeedWorld subject = new GeneratesSeedWorld();

  @Test
  public void test() {
    World result = subject.generate();
    
    assertThat(result, instanceOf(SeedWorld.class));
  }
}
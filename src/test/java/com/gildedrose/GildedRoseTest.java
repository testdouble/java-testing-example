package com.gildedrose;

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
public class GildedRoseTest {

  GildedRose subject;
  
  Item[] items = new Item[]{ mock(Item.class), mock(Item.class)};  
  @Mock UpdatesItemQuality updatesItemQuality;
  
  @Before
  public void setup() {
    subject = new GildedRose(items);
    subject.updatesItemQuality = updatesItemQuality;
  }

  @Test
  public void test() {    
    subject.updateQuality();
    
    verify(updatesItemQuality).updateItem(items[0]);
    verify(updatesItemQuality).updateItem(items[1]);
  }
}
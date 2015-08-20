package com.gildedrose;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    Item newItem0 = mock(Item.class);
    Item newItem1 = mock(Item.class);
    when(updatesItemQuality.updateItem(items[0])).thenReturn(newItem0);
    when(updatesItemQuality.updateItem(items[1])).thenReturn(newItem1);
    
    subject.updateQuality();
    
    assertThat(items[0], is(newItem0));
    assertThat(items[1], is(newItem1));
  }
}
package com.gildedrose;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

  Item[] items = new Item[2];
  
  @InjectMocks
  GildedRose subject = new GildedRose(items);
  
  @Mock UpdatesItem updatesItem;

  @Test
  public void test() {
    Item item1 = new Item("",-1,-1);
    Item updatedItem1 = new Item("",-1,-1);
    items[0] = item1;
    when(updatesItem.updatesItem(item1)).thenReturn(updatedItem1);
    Item item2 = new Item("",-1,-1);
    Item updatedItem2 = new Item("",-1,-1);
    items[1] = item2;
    when(updatesItem.updatesItem(item2)).thenReturn(updatedItem2);
    
    subject.updateQuality();
        
    assertThat(items[0], is(updatedItem1));
    assertThat(items[1], is(updatedItem2));
  }
}
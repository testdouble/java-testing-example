package com.gildedrose;

import static org.mockito.Mockito.*;

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
    Item item = new Item("",-1,-1);
    items[0] = item;
    Item item2 = new Item("",-1,-1);
    items[1] = item2;
    
    subject.updateQuality();
        
    verify(updatesItem, times(1)).updatesItem(item);
    verify(updatesItem, times(1)).updatesItem(item2);
  }
}
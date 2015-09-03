package com.gildedrose;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UpdatesItemTest {

  UpdatesItem subject = new UpdatesItem();

  @Test
  public void testBasicDecrease() {
    Item item = new Item("foo", 20, 20);

    Item result = subject.update(item);

    assertThat(result.quality, is(19));
    assertThat(result.sellIn, is(19));
  }

  @Test
  public void testSingleDecreaseWhenSellInIsOne() {
    Item item = new Item("foo", 1, 10);

    Item result = subject.update(item);

    assertThat(result.quality, is(9));
    assertThat(result.sellIn, is(0));
  }

  @Test
  public void testDoubleDecreaseWhenSellInIsZero() {
    Item item = new Item("foo", 0, 10);

    Item result = subject.update(item);

    assertThat(result.quality, is(8));
    assertThat(result.sellIn, is(-1));
  }

  @Test
  public void testDoubleDecreaseWhenSellInIsNegative() {
    Item item = new Item("foo", -20, 10);

    Item result = subject.update(item);

    assertThat(result.quality, is(8));
    assertThat(result.sellIn, is(-21));
  }

  @Test
  public void testQualityGoesToZeroWhenOne() {
    Item item = new Item("foo", 20, 1);

    Item result = subject.update(item);

    assertThat(result.quality, is(0));
  }

  @Test
  public void testQualityStaysAtZeroWhenZero() {
    Item item = new Item("foo", 20, 0);

    Item result = subject.update(item);

    assertThat(result.quality, is(0));
  }

  @Test
  public void testQualityGoesToZeroEvenWhenDroppingAtARateOfTwo() {
    Item item = new Item("foo", -20, 1);

    Item result = subject.update(item);

    assertThat(result.quality, is(0));
  }

  @Test
  public void agedBrieQualityIncreases() {
    Item item = new Item("Aged Brie", 20, 6);

    Item result = subject.update(item);

    assertThat(result.quality, is(7));
  }

  @Test
  public void agedBrieQualityIncreasesTo50() {
    Item item = new Item("Aged Brie", 20, 49);

    Item result = subject.update(item);

    assertThat(result.quality, is(50));
  }

  @Test
  public void agedBrieQualityStaysAt50() {
    Item item = new Item("Aged Brie", 20, 50);

    Item result = subject.update(item);

    assertThat(result.quality, is(50));
  }

  @Test
  public void sulfurasNeverChanges() {    
    Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(80));
    assertThat(result.sellIn, is(0));
  }
  
  @Test
  public void backstageIncreases() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(41));
    assertThat(result.sellIn, is(10));
  }
  
  @Test
  public void backstageIncreasesTwiceAsFastAt10() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(42));
    assertThat(result.sellIn, is(9));
  }
  
  @Test
  public void backstageIncreasesTwiceAsFastAt9() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 40);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(42));
    assertThat(result.sellIn, is(8));
  }
  
  @Test
  public void backstageIncreasesThreeTimesAsFastAt5() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(43));
    assertThat(result.sellIn, is(4));
  }
  
  @Test
  public void backstageIncreasesThreeTimesAsFastAt1() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 40);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(43));
    assertThat(result.sellIn, is(0));
  }

  @Test
  public void backstageGoesTo50AtDoubleRate() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 48);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(50));
    assertThat(result.sellIn, is(6));
  }
  
  @Test
  public void backstageDontGoOver50() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(50));
    assertThat(result.sellIn, is(0));
  }
  
  @Test
  public void backstageIsWorthlessAtZero() {    
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);
    
    Item result = subject.update(item);
    
    assertThat(result.quality, is(0));
    assertThat(result.sellIn, is(-1));
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
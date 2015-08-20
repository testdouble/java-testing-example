package com.gildedrose;

public class UpdatesItemQuality {

  /*
   * for each type of item, these things influence nightly changes:
   *   - sellIn value
   *   
   * type & sell-in is what matters…
   * 
   * currently type is represented by a string, which suggests primitive obsession
   * 
   * QualityUpdaterFactory returns a QualityUpdater based on name 
   * 
   * one quality updater for each type, all with one interface
   * 
   * 
   * bonus:
   *  - would love to get rid of mutation and return new items instead
   *  - need a test around the gilded rose object (can be mockito
   */
  
  public void updateItem(Item item) {
    int qualityDecreaseAmount;
    if(item.name == "Conjured") {
      qualityDecreaseAmount = 2;
    } else {
      qualityDecreaseAmount = 1;
    }
    
    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (item.quality > 0) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
          item.quality = item.quality - qualityDecreaseAmount;
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
  
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.sellIn < 11) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
  
          if (item.sellIn < 6) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }
  
    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn = item.sellIn - 1;
    }
  
    if (item.sellIn < 0) {
      if (!item.name.equals("Aged Brie")) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
              item.quality = item.quality - qualityDecreaseAmount;
            }
          }
        } else {
          item.quality = 0;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
    
    if(item.quality < 0) {
      item.quality = 0;
    }
  }

}

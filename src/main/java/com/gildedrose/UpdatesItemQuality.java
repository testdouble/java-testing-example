package com.gildedrose;

public class UpdatesItemQuality {
  
  public class QualityAdjuster {
    public int adjust(Item item, int size) {
      int newQuality;
      if(item.sellIn > 0) {
        newQuality = item.quality + size;
      } else {
        newQuality = item.quality + (size * 2);
      }
      
      if(size < 0) {
        return Math.max(newQuality, 0);
      } else {
        return Math.min(newQuality, 50);
      }
    }
  }
  
  public class UpdatesItemsFactory {
    public UpdatesItem updaterFor(Item item) { 
      if(item.name == "Backstage passes to a TAFKAL80ETC concert") {
        return new UpdatesSpecialEventItem();
      } else if(item.name == "Aged Brie") { 
        return new UpdatesQualityIncreasingItem();
      } else if(item.name == "Sulfuras, Hand of Ragnaros") {
        return new UpdatesUnchangingItem();
      } else if(item.name.startsWith("Conjured")) {
        return new UpdatesConjuredItem();
      } else {
        return new UpdatesRegularItem();
      }
    }
    
  }
  
  public interface UpdatesItem {
    public Item update(Item item);
  }
  
  public class UpdatesRegularItem implements UpdatesItem {
    public Item update(Item item) {
      return new Item(item.name, item.sellIn - 1, new QualityAdjuster().adjust(item, - 1));
    }    
  }
  
  public class UpdatesQualityIncreasingItem implements UpdatesItem {
    public Item update(Item item) {
      return new Item(item.name, item.sellIn - 1, new QualityAdjuster().adjust(item, 1));
    }    
  }
  
  public class UpdatesUnchangingItem implements UpdatesItem {
    public Item update(Item item) {
      return item;
    }    
  }
  
  public class UpdatesSpecialEventItem implements UpdatesItem {
    public Item update(Item item) {
      int newQuality;
      if(item.sellIn <= 0) {
        newQuality = 0;
      } else if(item.sellIn <= 5) {
        newQuality = item.quality + 3;
      } else if(item.sellIn <= 10) {
        newQuality = item.quality + 2;
      } else {
        newQuality = item.quality + 1;
      }
              
      return new Item(item.name, item.sellIn - 1, Math.min(newQuality, 50));
    }    
  }
  
  public class UpdatesConjuredItem implements UpdatesItem {
    public Item update(Item item) {
      return new Item(item.name, item.sellIn - 1, new QualityAdjuster().adjust(item, -2));
    }    
  }
  
  UpdatesItemsFactory updatesItemsFactory = new UpdatesItemsFactory();
  
  public Item updateItem(Item item) {
    return updatesItemsFactory.updaterFor(item).update(item);
  }

}

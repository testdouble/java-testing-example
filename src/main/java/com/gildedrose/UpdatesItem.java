package com.gildedrose;

public class UpdatesItem {

  
  public interface ItemUpdater {
    public Item update(Item item);
  }
  
  public class RateOfChangeUpdater implements ItemUpdater {
    
    int rate;
    
    public RateOfChangeUpdater(int rate) {
      this.rate = rate;
    }
    
    public Item update(Item item) {
      int newQuality;
      if(item.sellIn > 0) {
        newQuality = item.quality + rate;
      } else {
        newQuality = item.quality + (rate * 2);
      }
      
      item.sellIn--;
      item.quality = Math.min(Math.max(newQuality, 0), 50);
      return item;
    }
  }
  
  public class NormalItemUpdater extends RateOfChangeUpdater {
    public NormalItemUpdater() {
      super(-1);
    }
  }

  public class VintageItemUpdater extends RateOfChangeUpdater {
    public VintageItemUpdater() {
      super(1);
    }    
  }

  public class SpecialEventItemUpdater implements ItemUpdater {
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
      
      item.sellIn--;
      item.quality = Math.min(newQuality, 50);
      return item;
    }
  }
  
  public class NoOpItemUpdater implements ItemUpdater {
    public Item update(Item item) {
      return item;
    }
  }
  
  public class ItemUpdaterFactory {
    public ItemUpdater updaterFor(String name) {
      if(name == "Backstage passes to a TAFKAL80ETC concert") {
        return new SpecialEventItemUpdater();
      } else if(name == "Aged Brie") {
        return new VintageItemUpdater();
      } else if(name == "Sulfuras, Hand of Ragnaros") {
        return new NoOpItemUpdater();
      } else {
        return new NormalItemUpdater();
      }
    }
  }
  
  
  public void updatesItem(Item item) {
    new ItemUpdaterFactory().updaterFor(item.name).update(item);
  }

}

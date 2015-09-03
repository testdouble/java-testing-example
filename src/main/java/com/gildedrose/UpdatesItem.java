package com.gildedrose;

public class UpdatesItem {
  
  public interface AgesItem {
    public Item age(Item item);
  }
  
  public class AgesItemAtVariableRate implements AgesItem {
    
    int rate;
    
    public AgesItemAtVariableRate(int rate) {
      this.rate = rate;
    }
    
    public Item age(Item item) {
      int newQuality;
      if(item.sellIn > 0) {
        newQuality = item.quality + rate;
      } else {
        newQuality = item.quality + (rate * 2);
      }
      
      return new Item(item.name, item.sellIn - 1, Math.min(Math.max(newQuality, 0), 50));
    }
  }
  
  public class AgesNormalItem extends AgesItemAtVariableRate {
    public AgesNormalItem() {
      super(-1);
    }
  }

  public class AgesVintageItem extends AgesItemAtVariableRate {
    public AgesVintageItem() {
      super(1);
    }    
  }

  public class AgesSpecialEventItem implements AgesItem {
    public Item age(Item item) {
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
  
  public class AgesImmutableItem implements AgesItem {
    public Item age(Item item) {
      return item;
    }
  }
  
  public class ProvidesAgesItem {
    public AgesItem provide(String name) {
      if(name == "Backstage passes to a TAFKAL80ETC concert") {
        return new AgesSpecialEventItem();
      } else if(name == "Aged Brie") {
        return new AgesVintageItem();
      } else if(name == "Sulfuras, Hand of Ragnaros") {
        return new AgesImmutableItem();
      } else {
        return new AgesNormalItem();
      }
    }
  }
  
  public Item update(Item item) {
    return new ProvidesAgesItem().provide(item.name).age(item);
  }

}

package com.gildedrose;

import java.util.Arrays;
import java.util.Collection;

public class UpdatesItem {

  public interface NeedsQualityAdjustment {
    public boolean need(Item item);
  }
  
  public class RateOfQualityChange {
    int amount;
    NeedsQualityAdjustment test;

    public RateOfQualityChange(int amount, NeedsQualityAdjustment test) {
      this.amount = amount;
      this.test = test;
    }
    
    public boolean doesApply(Item item) {
      return test.need(item);
    }
  }
  
  public interface AgesItem {
    public Item age(Item item);
  }
  
  public class AgesItemAtVariableRate implements AgesItem {
    Collection<RateOfQualityChange> rates;
    
    public AgesItemAtVariableRate(RateOfQualityChange... rates) {
      this.rates = Arrays.asList(rates);
    }
    
    public Item age(Item item) {
      int newQuality = item.quality;
      for(RateOfQualityChange rate : rates) {
        if(rate.doesApply(item)) {
          newQuality += rate.amount;
        }
      }
      return new Item(item.name, item.sellIn - 1, Math.min(Math.max(newQuality, 0), 50));
    }
  }
  
  public class AgesNormalItem extends AgesItemAtVariableRate {
    public AgesNormalItem() {
      super(
        new RateOfQualityChange(-1, (item) -> true),
        new RateOfQualityChange(-1, (item) -> item.sellIn <= 0)
      );
    }
  }

  public class AgesVintageItem extends AgesItemAtVariableRate {
    public AgesVintageItem() {
      super(
        new RateOfQualityChange(1, (item) -> true),
        new RateOfQualityChange(1, (item) -> item.sellIn <= 0)
      );
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

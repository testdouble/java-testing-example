package com.gildedrose;

import java.util.Arrays;
import java.util.Collection;

// See: https://github.com/testdouble/contributing-tests/wiki/Gilded-Rose-Kata
public class UpdatesItem {

  public Item update(Item item) {
    return new ProvidesAgesItem().provide(item.name).age(item);
  }

  public class ProvidesAgesItem {
    public AgesItem provide(String name) {
      if (name == "Backstage passes to a TAFKAL80ETC concert") {
        return new AgesSpecialEventItem();
      } else if (name == "Aged Brie") {
        return new AgesVintageItem();
      } else if (name == "Sulfuras, Hand of Ragnaros") {
        return new AgesImmutableItem();
      } else if (name.startsWith("Conjured")) {
        return new AgesConjuredItem();
      } else {
        return new AgesNormalItem();
      }
    }
  }

  public interface AgesItem {
    public Item age(Item item);
  }

  public class AgesItemAtVariableRates implements AgesItem {
    Collection<QualityChangeRule> rules;

    public AgesItemAtVariableRates(QualityChangeRule... rates) {
      this.rules = Arrays.asList(rates);
    }

    public Item age(Item item) {
      int newQuality = item.quality;
      for (QualityChangeRule rule : rules) {
        if (rule.doesApply(item)) {
          newQuality += rule.amount;
        }
      }
      return new Item(item.name, item.sellIn - 1, Math.min(Math.max(newQuality, 0), 50));
    }
  }

  public class AgesNormalItem extends AgesItemAtVariableRates {
    public AgesNormalItem() {
      super(
          new QualityChangeRule(-1, (sellIn) -> true), 
          new QualityChangeRule(-1, (sellIn) -> sellIn <= 0));
    }
  }

  public class AgesVintageItem extends AgesItemAtVariableRates {
    public AgesVintageItem() {
      super(
          new QualityChangeRule(1, (sellIn) -> true), 
          new QualityChangeRule(1, (sellIn) -> sellIn <= 0));
    }
  }

  public class AgesSpecialEventItem extends AgesItemAtVariableRates {
    public AgesSpecialEventItem() {
      super(
          new QualityChangeRule(1, (sellIn) -> true), 
          new QualityChangeRule(1, (sellIn) -> sellIn <= 10),
          new QualityChangeRule(1, (sellIn) -> sellIn <= 5), 
          new QualityChangeRule(-1000000, (sellIn) -> sellIn <= 0));
    }
  }

  public class AgesImmutableItem implements AgesItem {
    public Item age(Item item) {
      return item;
    }
  }

  public class AgesConjuredItem extends AgesItemAtVariableRates {
    public AgesConjuredItem() {
      super(
          new QualityChangeRule(-2, (sellIn) -> true), 
          new QualityChangeRule(-2, (sellIn) -> sellIn <= 0));
    }
  }

  public class QualityChangeRule {
    int amount;
    SellInTest test;

    public QualityChangeRule(int amount, SellInTest test) {
      this.amount = amount;
      this.test = test;
    }

    public boolean doesApply(Item item) {
      return test.need(item.sellIn);
    }
  }

  public interface SellInTest {
    public boolean need(int sellIn);
  }
}

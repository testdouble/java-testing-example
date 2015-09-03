package com.gildedrose;

class GildedRose {
  Item[] items;

  UpdatesItem updatesItem = new UpdatesItem();
  
  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      updatesItem.updatesItem(items[i]);
    }
  }
}
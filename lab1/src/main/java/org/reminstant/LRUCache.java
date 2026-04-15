package org.reminstant;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public class LRUCache {

  private final int capacity;
  private final SequencedMap<String, String> storage;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.storage = new LinkedHashMap<>(capacity, 1f, true);
  }

  public String get(String key) {
    return storage.getOrDefault(key, "");
  }

  public void set(String key, String value) {
    storage.putLast(key, value);
    if (storage.size() > capacity) {
      storage.pollFirstEntry();
    }
  }

  public void rem(String key) {
    storage.remove(key);
  }
}

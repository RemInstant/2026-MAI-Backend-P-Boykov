package org.reminstant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTests {

  @Test
  void testLRUCache() {
    LRUCache cache = new LRUCache(100);
    cache.set("Jesse", "Pinkman");
    cache.set("Walter", "White");
    cache.set("Jesse", "James");
    String jesseValue = cache.get("Jesse");
    cache.rem("Walter");
    String walterValue = cache.get("Walter");

    assertThat(jesseValue).isEqualTo("James");
    assertThat(walterValue).isEmpty();
  }
}

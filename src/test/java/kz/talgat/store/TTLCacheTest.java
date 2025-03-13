package kz.talgat.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTLCacheTest {

    @Test
    void shouldCreateTTLCache() throws InterruptedException {
        var cache = new TTLCache<String>(8000);

        String key1 = cache.push("Test 1");
        System.out.println("Pushed key: " + key1);

        String key2 = cache.push("Short-lived value", 3000);
        System.out.println("Pushed key: " + key2);

        Thread.sleep(3000);
        assertEquals(cache.get(key1), "Test 1");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cache.get(key2);
        }, "Key " + key2 + " is expired");

        // Shutdown the cache
        cache.shutdown();
    }
}
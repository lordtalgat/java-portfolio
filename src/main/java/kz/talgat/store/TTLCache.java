package kz.talgat.store;

import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TTLCache<T> implements Cache<T> {

    private TreeMap<String, T> cacheMap = new TreeMap<>(); // To store cache values
    private TreeMap<String, Long> cacheExpiration = new TreeMap<>();
    private ScheduledExecutorService cleaner = Executors.newScheduledThreadPool(1);

    private long defaultTTL;

    public TTLCache(long defaultTTL) {
        this.defaultTTL = defaultTTL;
    }

    @Override
    public String push(T value) {
        return push(value, defaultTTL);
    }

    public String push(T value, long ttl) {
        String key = UUID.randomUUID().toString();
        Long expirationTime = System.currentTimeMillis() + ttl;
        cacheMap.put(key, value);
        cacheExpiration.put(key, expirationTime);
        return key;
    }

    private Boolean isExpired(String key) {
        var expirationTime = cacheExpiration.get(key);
        if (expirationTime == null) return true;
        else return System.currentTimeMillis() > expirationTime;
    }

    @Override
    public T get(String key) {
        if (isExpired(key)) {
            removeKeys(key);
            throw new IllegalArgumentException("Key " + key + " is expired");
        } else {
            return cacheMap.get(key);
        }
    }

    void removeKeys(String key) {
        cacheMap.remove(key);
        cacheExpiration.remove(key);
    }

    private void startCleanupTask() {
        cleaner.scheduleAtFixedRate(() ->{
           long currentTime = System.currentTimeMillis();
           cacheExpiration.forEach((key, exp) -> {
               if (currentTime > exp) {
                   removeKeys(key);
               }
           });
        },6, 1, TimeUnit.SECONDS);
    }

    public void shutdown() {
        cleaner.shutdown();
    }
}

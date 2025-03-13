package kz.talgat.store;

// Create TTL store to store data
// Live coding

public interface Cache<T> {
    public String push(T value);

    public T get(String key);
}

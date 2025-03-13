package kz.talgat.store;

// Create TTL store to store data
// Live codding

public interface Cache<T> {
    public String push(T value);

    public T get(String key);
}

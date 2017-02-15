package io.github.hylinn.xwing.registry;

public interface Registry<T> {
    void register(String key, T t);
    T get(String key);
}

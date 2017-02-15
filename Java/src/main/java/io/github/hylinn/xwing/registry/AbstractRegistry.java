package io.github.hylinn.xwing.registry;

import java.util.HashMap;

public class AbstractRegistry<T> implements Registry<T> {
    private final HashMap<String, T> registry = new HashMap<>();

    @Override
    public void register(String key, T t) {
        registry.put(key, t);
    }

    @Override
    public T get(String key) {
        return registry.get(key);
    }
}

package io.github.hylinn.xwing;

public interface Person {
    String name();
    boolean isUnique();
    boolean same(Person person);
}

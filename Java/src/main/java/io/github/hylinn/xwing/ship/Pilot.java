package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Person;

public class Pilot implements Person {

    @Override
    public String name() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isUnique() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean same(Person person) {
        return name().equals(person.name());
    }

    public int skill() {
        throw new UnsupportedOperationException();
    }

    public boolean isElite() {
        throw new UnsupportedOperationException();
    }
}

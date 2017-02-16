package io.github.hylinn.xwing.upgrade;

import io.github.hylinn.xwing.Person;
import io.github.hylinn.xwing.constraint.upgrade.UpgradeConstraint;

public class Crew extends Upgrade implements Person {
    public Crew(UpgradeConstraint constraint) {
        super(constraint);
    }

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
        throw new UnsupportedOperationException();
    }
}

package io.github.hylinn.xwing.upgrade;

import io.github.hylinn.xwing.constraint.upgrade.UpgradeConstraint;

public abstract class Upgrade {
    protected final UpgradeConstraint constraint;

    public Upgrade(UpgradeConstraint constraint) {
        this.constraint = constraint;
    }
}


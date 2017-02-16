package io.github.hylinn.xwing.upgrade.slot;

import io.github.hylinn.xwing.constraint.upgrade.UpgradeConstraint;
import io.github.hylinn.xwing.upgrade.Upgrade;

public abstract class UpgradeSlot<U extends Upgrade> {
    protected U upgrade;

    public void fill(U upgrade) {
        throw new UnsupportedOperationException();
    }

    public void empty() {
        throw new UnsupportedOperationException();
    }

    public boolean isFilled() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }
}

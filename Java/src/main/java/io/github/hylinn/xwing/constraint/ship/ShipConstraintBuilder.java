package io.github.hylinn.xwing.constraint.ship;

import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.constraint.validation.ValidationResultFactory;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class ShipConstraintBuilder {
    protected final Collection<Constraint<Ship, Upgrade>> upgradeConstraints;
    protected final ValidationResultFactory factory;

    public ShipConstraintBuilder(ValidationResultFactory factory) {
        upgradeConstraints = createUpgradeConstraints();
        this.factory = factory;
    }

    public ShipConstraintBuilder addUpgradeConstraint(Constraint<Ship, Upgrade> constraint) {
        upgradeConstraints.add(constraint);
        return this;
    }

    public ShipConstraint build() {
        return new ShipConstraint(this);
    }

    protected Collection<Constraint<Ship, Upgrade>> createUpgradeConstraints() {
        return new HashSet<>();
    }
}

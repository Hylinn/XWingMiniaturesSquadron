package io.github.hylinn.xwing.constraint.ship;

import io.github.hylinn.xwing.constraint.squadron.SquadronConstraint;
import io.github.hylinn.xwing.constraint.squadron.SquadronConstraints;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class ShipConstraintCollector {
    private final Collection<ShipConstraint<Upgrade>> upgradeConstraints;

    public ShipConstraintCollector() {
        upgradeConstraints = createUpgradeConstraints();
    }

    public ShipConstraintCollector addUpgradeConstraint(ShipConstraint<Upgrade> constraint) {
        upgradeConstraints.add(constraint);
        return this;
    }

    public ShipConstraints createSquadronConstraints() {
        return new ShipConstraints(upgradeConstraints);
    }

    protected Collection<ShipConstraint<Upgrade>> createUpgradeConstraints() {
        return new HashSet<>();
    }
}

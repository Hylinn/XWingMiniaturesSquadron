package io.github.hylinn.xwing.constraint.squadron;

import io.github.hylinn.xwing.Faction;
import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class SquadronConstraintCollector {
    private final Collection<SquadronConstraint<Upgrade>> upgradeConstraints;
    private final Collection<SquadronConstraint<Ship>> shipConstraints;

    public SquadronConstraintCollector() {
        upgradeConstraints = createUpgradeConstraints();
        shipConstraints = createShipConstraints();
    }

    public SquadronConstraintCollector addUpgradeConstraint(SquadronConstraint<Upgrade> constraint) {
        upgradeConstraints.add(constraint);
        return this;
    }

    public SquadronConstraintCollector addShipConstraint(SquadronConstraint<Ship> constraint) {
        shipConstraints.add(constraint);
        return this;
    }

    public SquadronConstraints createSquadronConstraints() {
        return new SquadronConstraints(upgradeConstraints, shipConstraints);
    }

    protected Collection<SquadronConstraint<Upgrade>> createUpgradeConstraints() {
        return new HashSet<>();
    }

    protected Collection<SquadronConstraint<Ship>> createShipConstraints() {
        return new HashSet<>();
    }
}

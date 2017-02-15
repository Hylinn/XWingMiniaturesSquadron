package io.github.hylinn.xwing.constraint.squadron;

import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.constraint.validation.ValidationResultFactory;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class SquadronConstraintBuilder {
    protected final Collection<Constraint<Squadron, Upgrade>> upgradeConstraints;
    protected final Collection<Constraint<Squadron, Ship>> shipConstraints;
    protected final ValidationResultFactory factory;

    public SquadronConstraintBuilder(ValidationResultFactory factory) {
        upgradeConstraints = createUpgradeConstraints();
        shipConstraints = createShipConstraints();
        this.factory = factory;
    }

    public SquadronConstraintBuilder addUpgradeConstraint(Constraint<Squadron, Upgrade> constraint) {
        upgradeConstraints.add(constraint);
        return this;
    }

    public SquadronConstraintBuilder addShipConstraint(Constraint<Squadron, Ship> constraint) {
        shipConstraints.add(constraint);
        return this;
    }

    public SquadronConstraint build() {
        return new SquadronConstraint(this);
    }

    protected Collection<Constraint<Squadron, Upgrade>> createUpgradeConstraints() {
        return new HashSet<>();
    }

    protected Collection<Constraint<Squadron, Ship>> createShipConstraints() {
        return new HashSet<>();
    }
}

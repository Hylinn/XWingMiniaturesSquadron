package io.github.hylinn.xwing.constraint.upgrade;

import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.constraint.squadron.SquadronConstraint;
import io.github.hylinn.xwing.constraint.validation.ValidationResultFactory;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class UpgradeConstraintBuilder {
    protected final Collection<Constraint<Upgrade, Squadron>> squadronConstraints;
    protected final Collection<Constraint<Upgrade, Ship>> shipConstraints;
    protected final ValidationResultFactory factory;

    public UpgradeConstraintBuilder(ValidationResultFactory factory) {
        squadronConstraints = createSquadronConstraints();
        shipConstraints = createShipConstraints();
        this.factory = factory;
    }

    public UpgradeConstraintBuilder addSquadronConstraint(Constraint<Upgrade, Squadron> constraint) {
        squadronConstraints.add(constraint);
        return this;
    }

    public UpgradeConstraintBuilder addShipConstraint(Constraint<Upgrade, Ship> constraint) {
        shipConstraints.add(constraint);
        return this;
    }

    public UpgradeConstraint build() {
        return new UpgradeConstraint(this);
    }

    protected Collection<Constraint<Upgrade, Squadron>> createSquadronConstraints() {
        return new HashSet<>();
    }

    protected Collection<Constraint<Upgrade, Ship>> createShipConstraints() {
        return new HashSet<>();
    }
}

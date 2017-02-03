package io.github.hylinn.xwing.constraint.squadron;

import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;

public class SquadronConstraints {
    private final Collection<SquadronConstraint<Upgrade>> upgradeConstraints;
    private final Collection<SquadronConstraint<Ship>> shipConstraints;

    protected SquadronConstraints(Collection<SquadronConstraint<Upgrade>> upgrade, Collection<SquadronConstraint<Ship>> ship) {
        this.upgradeConstraints = upgrade;
        this.shipConstraints = ship;
    }

    public boolean validateUpgrade(Squadron squadron, Upgrade upgrade) {
        for (SquadronConstraint<Upgrade> constraint : upgradeConstraints) {
            if (!constraint.validate(squadron, upgrade))
                return false;
        }
        return true;
    }

    public boolean validateShip(Squadron squadron, Ship ship) {
        for (SquadronConstraint<Ship> constraint : shipConstraints) {
            if (!constraint.validate(squadron, ship))
                return false;
        }
        return true;
    }
}

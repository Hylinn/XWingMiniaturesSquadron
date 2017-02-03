package io.github.hylinn.xwing.constraint.ship;

import io.github.hylinn.xwing.constraint.squadron.SquadronConstraint;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;

public class ShipConstraints {
    private final Collection<ShipConstraint<Upgrade>> upgradeConstraints;

    protected ShipConstraints(Collection<ShipConstraint<Upgrade>> upgrade) {
        this.upgradeConstraints = upgrade;
    }

    public boolean validateUpgrade(Ship ship, Upgrade upgrade) {
        for (ShipConstraint<Upgrade> constraint : upgradeConstraints) {
            if (!constraint.validate(ship, upgrade))
                return false;
        }
        return true;
    }
}

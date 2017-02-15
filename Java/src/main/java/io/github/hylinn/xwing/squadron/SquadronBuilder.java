package io.github.hylinn.xwing.squadron;

import io.github.hylinn.xwing.constraint.squadron.SquadronConstraint;
import io.github.hylinn.xwing.ship.ShipBuilder;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class SquadronBuilder {
    private final SquadronConstraint constraint;

    protected final Collection<ShipBuilder> ships = new HashSet<>();

    public SquadronBuilder(SquadronConstraint constraint) {
        this.constraint = constraint;
    }

    public SquadronBuilder addShip(ShipBuilder ship) {
        throw new UnsupportedOperationException();
    }

    public SquadronBuilder addUpgradeToShip(Upgrade upgrade, ShipBuilder ship) {
        throw new UnsupportedOperationException();
    }

    public Squadron build() {
        return new Squadron(this);
    }
}

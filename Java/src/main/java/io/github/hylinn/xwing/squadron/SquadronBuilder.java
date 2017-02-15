package io.github.hylinn.xwing.squadron;

import io.github.hylinn.xwing.constraint.SquadronConstraint;
import io.github.hylinn.xwing.constraint.validation.ValidationResult;
import io.github.hylinn.xwing.ship.ShipBuilder;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class SquadronBuilder {

    private final SquadronConstraint constraint;
    private final Collection<ShipBuilder> ships = new HashSet<>();
    private final Squadron squadron = new Squadron();

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
        throw new UnsupportedOperationException();
    }
}

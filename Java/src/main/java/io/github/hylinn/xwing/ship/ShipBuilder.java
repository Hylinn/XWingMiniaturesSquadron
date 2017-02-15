package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Faction;
import io.github.hylinn.xwing.constraint.ship.ShipConstraint;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class ShipBuilder {
    private final ShipConstraint constraint;

    protected final Collection<Upgrade> upgrades = new HashSet<>();
    protected final ShipBase base;

    protected int cost;

    public ShipBuilder(ShipBase base, ShipConstraint constraint) {
        this.constraint = constraint;
        this.base = base;
        this.cost = base.getCost();
    }

    public ShipBuilder addUpgrade(Upgrade upgrade) {
        throw new UnsupportedOperationException();
    }

    public Ship build() {
        return new Ship(this);
    }
}

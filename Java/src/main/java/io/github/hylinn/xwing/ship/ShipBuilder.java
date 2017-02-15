package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Faction;
import io.github.hylinn.xwing.constraint.ship.ShipConstraint;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class ShipBuilder {
    private final ShipConstraint constraint;

    protected final Faction faction;
    protected final Pilot pilot;
    protected final ShipType type;
    protected final int baseCost;
    protected final Collection<Upgrade> upgrades = new HashSet<>();

    protected int cost;

    public ShipBuilder(Pilot pilot, ShipType type, Faction faction, int baseCost, ShipConstraint constraint) {
        this.constraint = constraint;
        this.pilot = pilot;
        this.type = type;
        this.faction = faction;
        this.baseCost = baseCost;
        this.cost = baseCost;
    }

    public ShipBuilder addUpgrade(Upgrade upgrade) {
        throw new UnsupportedOperationException();
    }

    public Ship build() {
        return new Ship(this);
    }
}

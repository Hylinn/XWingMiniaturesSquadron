package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Faction;

public class Ship {
    private final Faction faction;
    private final int cost;

    protected Ship(ShipBuilder builder) {
        this.faction = builder.faction;
        this.cost = builder.cost;
    }

    public Faction getFaction() {
        return faction;
    }

    public int getCost() {
        return cost;
    }
}

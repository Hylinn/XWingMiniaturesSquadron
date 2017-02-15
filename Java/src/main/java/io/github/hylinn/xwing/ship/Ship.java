package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Faction;

public class Ship {
    private final ShipBase base;
    private final int cost;

    protected Ship(ShipBuilder builder) {
        this.base = builder.base;
        this.cost = builder.cost;
    }

    public Faction getFaction() {
        return base.getFaction();
    }

    public int getCost() {
        return cost;
    }
}

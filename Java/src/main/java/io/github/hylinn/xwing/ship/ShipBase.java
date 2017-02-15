package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Faction;

public class ShipBase {
    private final Pilot pilot;
    private final ShipType type;
    private final Faction faction;
    private final int cost;

    public ShipBase(Pilot pilot, ShipType type, Faction faction, int cost) {
        this.pilot = pilot;
        this.type = type;
        this.faction = faction;
        this.cost = cost;
    }

    public int getCost() { return cost; }

    public Faction getFaction() { return faction; }
}

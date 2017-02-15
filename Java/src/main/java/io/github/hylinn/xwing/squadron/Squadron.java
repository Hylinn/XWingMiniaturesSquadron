package io.github.hylinn.xwing.squadron;

import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.ship.ShipBuilder;

import java.util.Collection;
import java.util.HashSet;

public class Squadron {
    private final Collection<Ship> ships = new HashSet<>();
    private final int totalCost;

    private int currentValue;

    protected Squadron(SquadronBuilder builder) {
        ships.addAll(buildShips(builder.ships));
        totalCost = calculateTotalCost(ships);
    }

    protected Collection<Ship> buildShips(Collection<ShipBuilder> builders) {
        Collection<Ship> ships = new HashSet<>();
        for(ShipBuilder builder : builders)
            ships.add(builder.build());
        return ships;
    }

    protected int calculateTotalCost(Collection<Ship> ships) {
        int cost = 0;
        for (Ship ship : ships)
            cost += ship.getCost();
        return cost;
    }

    public Collection<Ship> getShips() {
        return ships;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getCurrentValue() {
        return currentValue;
    }
}

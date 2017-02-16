package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.Faction;
import io.github.hylinn.xwing.upgrade.Modification;
import io.github.hylinn.xwing.upgrade.slot.EliteSlot;
import io.github.hylinn.xwing.upgrade.slot.ModificationSlot;
import io.github.hylinn.xwing.upgrade.slot.UpgradeSlotCollection;

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

    public UpgradeSlotCollection upgradeSlots() {
        UpgradeSlotCollection slots = new UpgradeSlotCollection();

        if (pilot.isElite())
            slots.add(new EliteSlot());

        slots.add(type.getUpgradeSlots());
        slots.add(new ModificationSlot());

        return slots;
    }
}

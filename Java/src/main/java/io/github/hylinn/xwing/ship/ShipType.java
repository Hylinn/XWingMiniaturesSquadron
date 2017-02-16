package io.github.hylinn.xwing.ship;

import io.github.hylinn.xwing.upgrade.slot.UpgradeSlot;

import java.util.Collection;

public abstract class ShipType {

    public abstract String getName();
    public abstract int getHull();
    public abstract int getShields();
    public abstract int getAgility();
    public abstract Collection<UpgradeSlot> getUpgradeSlots();
    //public abstract *Collection<Action>?* getActions();
    //public abstract *Weapon?* getPrimaryWeapon();
}

package io.github.hylinn.xwing.ship;

public abstract class ShipType {

    public abstract String getName();
    public abstract int getHull();
    public abstract int getShields();
    public abstract int getAgility();
    //public abstract *Weapon?* getPrimaryWeapon();
    //public abstract *Collection<UpgradeSlot>?* getUpgradeSlots();
    //public abstract *Collection<Action>?* getActions();
}

package io.github.hylinn.xwing.upgrade.slot;

import io.github.hylinn.xwing.upgrade.Upgrade;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpgradeSlotCollection {
    private final HashMap<Class, Collection<UpgradeSlot>> slots = new HashMap<>();

    public void add(UpgradeSlot slot) {
        Class key = slot.getClass();
        if (!slots.containsKey(key))
            slots.put(key, new HashSet<>());

        slots.get(key).add(slot);
    }

    public void add(Iterable<UpgradeSlot> slots) {
        slots.forEach(this::add);
    }

    public void remove(UpgradeSlot slot) {
        Class key = slot.getClass();
        slots.get(key).remove(slot);
    }

    public Collection<UpgradeSlot> allSlots() {
        Collection<UpgradeSlot> allSlots = new HashSet<>();
        slots.values().forEach(allSlots::addAll);

        return allSlots;
    }

    public Collection<UpgradeSlot> filledSlots() {
        return allSlots().stream()
                .filter(slot -> slot.isFilled())
                .collect(Collectors.toSet());
    }

    public Collection<UpgradeSlot> emptySlots() {
        return allSlots().stream()
                .filter(slot -> slot.isEmpty())
                .collect(Collectors.toSet());
    }

    public Collection<UpgradeSlot> emptySlots(Class type) {
        return slots.get(type).stream()
                .filter(slot -> slot.isEmpty())
                .collect(Collectors.toSet());
    }
}

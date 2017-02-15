package io.github.hylinn.xwing.dice.roller;

import io.github.hylinn.xwing.random.ChanceGenerator;

@FunctionalInterface
public interface Roller {
    ChanceGenerator.Dice roll();
}

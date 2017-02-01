package io.github.hylinn.xwing.dice.roller;

import io.github.hylinn.xwing.dice.random.ChanceGenerator;

public interface Roller {
    ChanceGenerator.Dice roll();
}

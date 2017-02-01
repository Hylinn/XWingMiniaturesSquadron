package io.github.hylinn.xwing.dice;

import io.github.hylinn.xwing.dice.random.ChanceGenerator;

public interface Dice {

    ChanceGenerator.Dice getResult();
    boolean canReroll();
    boolean reroll();
    boolean canSetResult();
    boolean setResult(ChanceGenerator.Dice result);
}

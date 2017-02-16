package io.github.hylinn.xwing.dice.roller;

import io.github.hylinn.xwing.random.ChanceGenerator;

import java.util.function.Supplier;

public class DefenseRoller implements Supplier<ChanceGenerator.Dice> {

    private final ChanceGenerator dice;

    public DefenseRoller(ChanceGenerator dice) {
        this.dice = dice;
    }

    @Override
    public ChanceGenerator.Dice get() {
        return dice.rollDefense();
    }
}

package io.github.hylinn.xwing.dice.roller;

import io.github.hylinn.xwing.random.ChanceGenerator;

import java.util.function.Supplier;

public class AttackRoller implements Supplier<ChanceGenerator.Dice> {

    private final ChanceGenerator dice;

    public AttackRoller(ChanceGenerator dice) {
        this.dice = dice;
    }

    @Override
    public ChanceGenerator.Dice get() {
        return dice.rollAttack();
    }
}

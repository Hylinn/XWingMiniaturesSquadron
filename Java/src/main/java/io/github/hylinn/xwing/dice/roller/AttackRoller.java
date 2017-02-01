package io.github.hylinn.xwing.dice.roller;

import io.github.hylinn.xwing.dice.random.ChanceGenerator;

public class AttackRoller implements Roller {

    private final ChanceGenerator dice;

    public AttackRoller(ChanceGenerator dice) {
        this.dice = dice;
    }

    @Override
    public ChanceGenerator.Dice roll() {
        return dice.rollAttack();
    }
}

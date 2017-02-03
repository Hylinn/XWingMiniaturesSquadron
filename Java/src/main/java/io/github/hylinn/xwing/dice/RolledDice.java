package io.github.hylinn.xwing.dice;

import io.github.hylinn.xwing.random.ChanceGenerator;
import io.github.hylinn.xwing.dice.roller.Roller;

public class RolledDice implements Dice {

    private final Roller roller;
    private ChanceGenerator.Dice result;

    private boolean hasRerolled = false;

    public RolledDice(Roller roller) {
        this.roller = roller;
        this.result = roller.roll();
    }

    public RolledDice(Roller roller, ChanceGenerator.Dice result) {
        this.roller = roller;
        this.result = result;
    }

    @Override
    public ChanceGenerator.Dice getResult() {
        return result;
    }

    @Override
    public boolean canReroll() {
        return !hasRerolled;
    }

    @Override
    public boolean reroll() {
        if (!canReroll()) return false;

        this.result = roller.roll();
        hasRerolled = true;
        return true;
    }

    @Override
    public boolean canSetResult() {
        return true;
    }

    @Override
    public boolean setResult(ChanceGenerator.Dice result) {
        if (!canSetResult()) return false;

        this.result = result;
        return true;
    }
}

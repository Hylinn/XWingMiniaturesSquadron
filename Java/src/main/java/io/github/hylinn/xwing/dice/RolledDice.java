package io.github.hylinn.xwing.dice;

import io.github.hylinn.xwing.random.ChanceGenerator;

import java.util.function.Supplier;

public class RolledDice implements Dice {

    private final Supplier<? extends ChanceGenerator.Dice> roller;
    private ChanceGenerator.Dice result;

    private boolean hasRerolled = false;

    public RolledDice(Supplier<? extends ChanceGenerator.Dice> roller) {
        this.roller = roller;
        this.result = roller.get();
    }

    public RolledDice(Supplier<? extends ChanceGenerator.Dice> roller, ChanceGenerator.Dice result) {
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

        this.result = roller.get();
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

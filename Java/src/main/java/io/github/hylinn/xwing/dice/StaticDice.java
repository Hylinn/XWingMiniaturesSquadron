package io.github.hylinn.xwing.dice;

import io.github.hylinn.xwing.random.ChanceGenerator;

public class StaticDice implements Dice {

    private final ChanceGenerator.Dice result;

    public StaticDice(ChanceGenerator.Dice result) {
        this.result = result;
    }

    @Override
    public ChanceGenerator.Dice getResult() {
        return result;
    }

    @Override
    public boolean canReroll() {
        return false;
    }

    @Override
    public boolean reroll() {
        return false;
    }

    @Override
    public boolean canSetResult() {
        return false;
    }

    @Override
    public boolean setResult(ChanceGenerator.Dice result) {
        return false;
    }
}

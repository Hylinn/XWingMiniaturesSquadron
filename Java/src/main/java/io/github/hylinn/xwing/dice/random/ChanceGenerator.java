package io.github.hylinn.xwing.dice.random;

import java.util.Random;

public class ChanceGenerator {
    private final Random random;

    public ChanceGenerator(Random random) {
        this.random = random;
    }

    public Coin flipCoin() {
        boolean flip = random.nextBoolean();
        return flip ? Coin.Heads : Coin.Tails;
    }

    public int rollD6() {
        return random.nextInt(6);
    }

    public int rollD8() {
        return random.nextInt(8);
    }

    public int rollDX(int x) {
        if (x == 0) return 0;
        return random.nextInt(x);
    }

    public Dice rollAttack() {
        int dice = rollD8();

        switch (dice) {
            case 0:
            case 1:
            case 2:
                return Dice.Hit;
            case 3:
            case 4:
                return Dice.Focus;
            case 5:
            case 6:
                return Dice.Blank;
            case 7:
                return Dice.Critical;
            default:
                throw new InvalidDiceResult(dice + " is not a valid dice result (must between 0 and 7, inclusive).");
        }
    }

    public Dice rollDefense() {
        int dice = rollD8();

        switch (dice) {
            case 0:
            case 1:
            case 2:
                return Dice.Evade;
            case 3:
            case 4:
                return Dice.Focus;
            case 5:
            case 6:
            case 7:
                return Dice.Blank;
            default:
                throw new InvalidDiceResult(dice + " is not a valid dice result (must between 0 and 7, inclusive).");
        }
    }

    public enum Dice {
        Blank, Evade, Hit, Critical, Focus
    }

    public enum Coin {
        Heads, Tails
    }
}

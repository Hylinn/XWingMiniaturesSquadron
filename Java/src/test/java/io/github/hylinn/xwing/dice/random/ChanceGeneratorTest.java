package io.github.hylinn.xwing.dice.random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

public class ChanceGeneratorTest {

    @Test
    public void testCoinFlipReturnsHeadsOnTrue() {
        ChanceGenerator.Coin expected = ChanceGenerator.Coin.Heads;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        ChanceGenerator.Coin actual = chance.flipCoin();

        assertEquals(expected, actual);
    }

    @Test
    public void testCoinFlipReturnsTailsOnFalse() {
        ChanceGenerator.Coin expected = ChanceGenerator.Coin.Tails;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(false);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        ChanceGenerator.Coin actual = chance.flipCoin();

        assertEquals(expected, actual);
    }

    @Test
    public void testRollD6CallsRandomWithProperRange() {
        final int expected = 6;

        Random mockRandom = mock(Random.class);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        chance.rollD6();

        verify(mockRandom).nextInt(expected);
    }

    @Test
    public void testRollD6ReturnsRandomResult() {
        final int sides = 6;
        Random random = new Random();
        final int expected = random.nextInt(sides);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(sides)).thenReturn(expected);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        int actual = chance.rollD6();

        assertEquals(expected, actual);
    }

    @Test
    public void testRollD8CallsRandomWithProperRange() {
        final int expected = 8;

        Random mockRandom = mock(Random.class);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        chance.rollD8();

        verify(mockRandom).nextInt(expected);
    }

    @Test
    public void testRollD8ReturnsRandomResult() {
        final int sides = 8;
        Random random = new Random();
        final int expected = random.nextInt(sides);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(sides)).thenReturn(expected);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        int actual = chance.rollD8();

        assertEquals(expected, actual);
    }

    @Test
    public void testRollDXCallsRandomWithProperRange() {
        Random random = new Random();
        final int expected = random.nextInt();

        Random mockRandom = mock(Random.class);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        chance.rollDX(expected);

        verify(mockRandom).nextInt(expected);
    }

    @Test
    public void testRollDXReturnsRandomResult() {
        Random random = new Random();
        final int sides = Math.abs(random.nextInt());
        final int expected = random.nextInt(sides);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(sides)).thenReturn(expected);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        int actual = chance.rollDX(sides);

        assertEquals(expected, actual);
    }

    @Test
    public void testRollDXWithZeroReturnsZero() {
        final int expected = 0;

        ChanceGenerator chance = new ChanceGenerator(null);
        int actual = chance.rollDX(0);

        assertEquals(expected, actual);
    }

    @Test
    public void testRollAttackCallsRandomWithProperRange() {
        final int expected = 8;

        Random mockRandom = mock(Random.class);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        chance.rollAttack();

        verify(mockRandom).nextInt(expected);
    }

    @Test
    public void testRollAttackReturnsHitInProperRange() {
        final int[] rolls = {0, 1, 2};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Hit;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0])
                                   .thenReturn(rolls[1])
                                   .thenReturn(rolls[2]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollAttack());
        assertEquals(expected, chance.rollAttack());
        assertEquals(expected, chance.rollAttack());
    }

    @Test
    public void testRollAttackReturnsFocusInProperRange() {
        final int[] rolls = {3, 4};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Focus;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0])
                                   .thenReturn(rolls[1]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollAttack());
        assertEquals(expected, chance.rollAttack());
    }

    @Test
    public void testRollAttackReturnsCriticalInProperRange() {
        final int[] rolls = {7};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Critical;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollAttack());
    }

    @Test
    public void testRollAttackReturnsBlankInProperRange() {
        final int[] rolls = {5, 6};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Blank;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0])
                                   .thenReturn(rolls[1]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollAttack());
        assertEquals(expected, chance.rollAttack());
    }

    @Test
    public void testRollDefenseCallsRandomWithProperRange() {
        final int expected = 8;

        Random mockRandom = mock(Random.class);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);
        chance.rollDefense();

        verify(mockRandom).nextInt(expected);
    }

    @Test
    public void testRollDefenseReturnsEvadeInProperRange() {
        final int[] rolls = {0, 1, 2};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Evade;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0])
                                   .thenReturn(rolls[1])
                                   .thenReturn(rolls[2]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollDefense());
        assertEquals(expected, chance.rollDefense());
        assertEquals(expected, chance.rollDefense());
    }

    @Test
    public void testRollDefenseReturnsFocusInProperRange() {
        final int[] rolls = {3, 4};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Focus;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0])
                                   .thenReturn(rolls[1]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollDefense());
        assertEquals(expected, chance.rollDefense());
    }

    @Test
    public void testRollDefenseReturnsBlankInProperRange() {
        final int[] rolls = {5, 6, 7};
        final ChanceGenerator.Dice expected = ChanceGenerator.Dice.Blank;

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(8)).thenReturn(rolls[0])
                                   .thenReturn(rolls[1])
                                   .thenReturn(rolls[2]);

        ChanceGenerator chance = new ChanceGenerator(mockRandom);

        assertEquals(expected, chance.rollDefense());
        assertEquals(expected, chance.rollDefense());
        assertEquals(expected, chance.rollDefense());
    }
}

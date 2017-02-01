package io.github.hylinn.xwing.dice.roller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import io.github.hylinn.xwing.dice.random.ChanceGenerator;
import org.junit.Test;

public class AttackRollerTest {

    @Test
    public void testRollCallsChanceGeneratorsRollAttack() {
        ChanceGenerator.Dice expected = ChanceGenerator.Dice.Hit;

        ChanceGenerator mockGenerator = mock(ChanceGenerator.class);
        when(mockGenerator.rollAttack()).thenReturn(expected);

        AttackRoller roller = new AttackRoller(mockGenerator);
        ChanceGenerator.Dice actual = roller.roll();

        assertEquals(expected, actual);
    }
}

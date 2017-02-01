package io.github.hylinn.xwing.dice.roller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import io.github.hylinn.xwing.dice.random.ChanceGenerator;
import org.junit.Test;

public class DefenseRollerTest {

    @Test
    public void testRollCallsChanceGeneratorsRollDefense() {
        ChanceGenerator.Dice expected = ChanceGenerator.Dice.Evade;

        ChanceGenerator mockGenerator = mock(ChanceGenerator.class);
        when(mockGenerator.rollDefense()).thenReturn(expected);

        DefenseRoller roller = new DefenseRoller(mockGenerator);
        ChanceGenerator.Dice actual = roller.roll();

        assertEquals(expected, actual);
    }
}

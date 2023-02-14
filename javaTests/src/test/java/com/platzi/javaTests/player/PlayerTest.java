package com.platzi.javaTests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void losesWhenDiceNumberIsLower() {
        // Here we are going to use the library Mockito to simulate an instance of the Dice class
        Dice dice = Mockito.mock(Dice.class);

        // We want the player losing every time in this test
        // So we need when they roll the dice, always get a number lower than the minNumberToWin (3 in this case)
        // For this we have to use Mockito.when() and thenReturn() methods
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3);
        assertFalse(player.play()); // It has to lose when play
    }

    @Test
    public void winsWhenDiceNumberIsHigher() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4); // When dice rolls it always return 4

        Player player = new Player(dice, 3);
        assertTrue(player.play()); // It has to win when play
    }
}
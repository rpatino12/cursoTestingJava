package com.platzi.javaTests.player;

import java.util.Random;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll(){
        // Let's get a random number with the dice with the class Random
        // The method nextInt() returns a number between zero and the number specified as an argument
        // So if the dice has 6 sides we have to sum one to get a number between 1 and 6
        return new Random().nextInt(sides) + 1;
    }
}

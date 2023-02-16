package com.platzi.javaTests.exercise;

import org.junit.Test;

import static com.platzi.javaTests.exercise.FizzBuzz.*;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void return_fizz_if_number_is_divisible_by_3() {
        assertEquals("Fizz", fizzBuzz(3));
        assertEquals("Fizz", fizzBuzz(6));
    }

    @Test
    public void return_buzz_if_number_is_divisible_by_5() {
        assertEquals("Buzz", fizzBuzz(5));
        assertEquals("Buzz", fizzBuzz(10));
    }

    @Test
    public void return_fizzbuzz_if_number_is_divisible_by_3_and_by_5() {
        assertEquals("FizzBuzz", fizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz(30));
    }

    @Test
    public void return_the_same_number_for_other_cases() {
        assertEquals("7", fizzBuzz(7));
        assertEquals("2", fizzBuzz(2));
    }
}
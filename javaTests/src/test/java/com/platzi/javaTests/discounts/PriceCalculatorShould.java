package com.platzi.javaTests.discounts;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {
    @Test
    public void return_zero_when_there_is_not_prices() {
        PriceCalculator calculator = new PriceCalculator();
        assertEquals(0, calculator.getTotal(), 0.01);
    }

    @Test
    public void return_the_sum_of_the_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(12.5);
        calculator.addPrice(1.0);
        calculator.addPrice(6.25);

        assertEquals(19.75, calculator.getTotal(), 0.01);
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50.5);

        calculator.setDiscount(30);

        assertEquals(140.35, calculator.getTotal(), 0.01);
    }
}
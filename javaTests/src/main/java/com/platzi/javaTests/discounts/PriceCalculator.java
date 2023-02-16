package com.platzi.javaTests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private final List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {
        double result = 0;
        for (Double price : prices) {
            result += price;
        }
        return result * (1 - (discount/100));
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

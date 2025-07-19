package com.example.pricecalculator;

public class PriceCalculator {
    public double getPriceWithTax(double basePrice) {
        double tax = calculateTax(basePrice);
        return basePrice + tax;
    }

    private double calculateTax(double basePrice) {
        // Simulated heavy/legacy private logic: division could cause ArithmeticException (simulate)
        return basePrice * 0.18;
    }
}

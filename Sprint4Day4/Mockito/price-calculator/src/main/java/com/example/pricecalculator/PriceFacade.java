package com.example.pricecalculator;

public class PriceFacade {
    private PriceCalculator priceCalculator;

    public PriceFacade(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public double getPrice(double basePrice) {
        try {
            return priceCalculator.getPriceWithTax(basePrice);
        } catch (ArithmeticException ex) {
            return -1.0;
        }
    }
}

package com.aayush209.javapractice.enumeration;

public enum LoyaltyLevel {
    BRONZE(0.1, 1),
    SILVER(0.2, 2),
    GOLD(0.3, 3),
    PLATINUM(0.4, 4);

    private final double discount;
    private final int multiplier;

    LoyaltyLevel(double discount, int multiplier) {
        this.discount = discount;
        this.multiplier = multiplier;
    }

    public double getDiscount() {
        return discount;
    }

    public int getMultiplier() {
        return multiplier;
    }
}


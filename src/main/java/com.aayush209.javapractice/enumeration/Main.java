package com.aayush209.javapractice.enumeration;

public class Main {

    public static void main(String[] args) {
        LoyaltyLevel loyaltyLevel = LoyaltyLevel.BRONZE;
        System.out.println("discount : " + loyaltyLevel.getDiscount() + " multiplier : " + loyaltyLevel.getMultiplier());
    }

}

package com.aayush209.javapractice.functionalinterface;

public class IncrementByFiveLambda {

    public static void main(String[] args) {
        IncrementByFive incrementByFiveLambda = (x) -> x + 5;
        System.out.println(incrementByFiveLambda.increment(6));
    }
}

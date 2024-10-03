package com.aayush209.javapractice.functionalinterface;

public class IncrementByFiveTraditional implements IncrementByFive{

    @Override
    public int increment(int a){
        return a+5;
    }

    public static void main(String[] args) {
        IncrementByFiveTraditional incrementByFiveTraditional = new IncrementByFiveTraditional();
        System.out.println(incrementByFiveTraditional.increment(6));
    }
}

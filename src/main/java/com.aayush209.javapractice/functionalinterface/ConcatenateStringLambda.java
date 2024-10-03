package com.aayush209.javapractice.functionalinterface;

public class ConcatenateStringLambda {

    public static void main(String[] args) {
        ConcatenateString concatenateStringLambda = (a, b) -> a + " " + b;
        System.out.println(concatenateStringLambda.concatenate("Hello", "World"));
    }

}

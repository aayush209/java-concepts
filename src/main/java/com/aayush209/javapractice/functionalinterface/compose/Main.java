package com.aayush209.javapractice.functionalinterface.compose;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> square = num -> num * num;
        Function<String, Integer> calcLength = str -> str.length();

        Function<String, Integer> composedFunction = square.compose(calcLength);

        System.out.println("Result : " + composedFunction.apply("Aayush Gupta")); // length 12, square will be 144
        //Note - compose function runs from right to left
        // hence the input is of format String and output is of format Integer in
        // Function<String, Integer> composedFunction

    }

}

package com.aayush209.javapractice.functionalinterface.customfunctionalinterface;

public class Main {
    //
    public static void main(String[] args) {
        MathOperation mathOperation1 = (num1, num2) -> num1 + num2;
        MathOperation mathOperation2 = (num1, num2) -> num1 - num2;
        MathOperation mathOperation3 = (num1, num2) -> num1 * num2;
        MathOperation mathOperation4 = (num1, num2) -> {
            if(num2 == 0.0)
                throw new ArithmeticException("Division by 0 not allowed");

            return num1 / num2;
        };

        System.out.println(mathOperation1.calc(2.0, 3.0));
        System.out.println(mathOperation2.calc(2.0, 3.0));
        System.out.println(mathOperation3.calc(2.0, 3.0));
        System.out.println(mathOperation4.calc(2.0, 3.0));
        System.out.println(mathOperation4.calc(2.0, 0.0));
    }
}

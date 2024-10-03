package com.aayush209.javapractice.functionalinterface.predicate;

import java.util.function.Predicate;

public class Main {

    // Predicate interface has more than one method, then why is it a functional interface?
    // A functional interface needs to have exactly one abstract method
    // whereas it can have any number of static and default methods
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isMultipleOf3 = num -> num % 3 == 0;
        Predicate<Integer> isPrime = num -> {
            if(num < 1) return false;
            for(int i = 2; i <= Math.sqrt(num) ; i++){
                if(num % i == 0)
                    return false;
            }
            return true;
        };

        System.out.println(isEven.and(isMultipleOf3).test(10));
        System.out.println(isEven.and(isMultipleOf3).test(30));
        System.out.println(isEven.and(isPrime).test(2));
        System.out.println(isEven.or(isPrime).test(5));
        System.out.println(isEven.or(isPrime).test(9));
    }

}

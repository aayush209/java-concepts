package com.aayush209.javapractice.functionalinterface.consumer;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    // Supplier - takes no argument but returns a value when get() method is called
    // Consumer - opposite of Supplier, accepts parameter in accept() method and returns void aka nothing
    public static void main(String[] args) {
        List<Person> personList = List.of(new Person("Homie", 39)
                , new Person("Homie2", 39)
                , new Person("Homie3", 42));

        Consumer<Person> increaseAge =  person -> person.increaseAge(1);

        Consumer<Person> printPerson =  person -> System.out.println("Person : " + person.toString());

        Consumer<Person> increaseAgeAndPrintPerson =  increaseAge.andThen(printPerson);

        personList.forEach(increaseAgeAndPrintPerson);

    }

}

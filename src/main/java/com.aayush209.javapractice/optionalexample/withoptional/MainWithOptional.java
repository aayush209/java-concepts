package com.aayush209.javapractice.optionalexample.withoptional;

import java.util.Optional;

public class MainWithOptional {

    public static void main(String[] args) {
        Person person = new Person(Optional.empty());
        Person person2 = new Person(Optional.of(new Address("Chandigarh")));

        String city = person
                .getAddress()
                .map(Address::getCity)
                .orElse("Unknown");

        printCityIfPresent(person); // won't print anything
        printCityIfPresent(person2); // will print "City via lambda: Chandigarh"

        System.out.println("City : " + city); // will print "City : Unknown"
    }

    private static void printCityIfPresent(Person person) {
        person.getAddress()
                .ifPresent((address -> System.out.println("City via lambda: " + address.getCity())));
    }

}

package com.aayush209.javapractice.optionalexample.withoutoptional;

public class Person {
    private final Address address;

    public Person(Address address){
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

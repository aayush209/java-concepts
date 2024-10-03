package com.aayush209.javapractice.optionalexample.withoptional;

import java.util.Optional;

public class Person {
    private final Optional<Address> address;

    public Person(Optional<Address> address){
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return address;
    }
}

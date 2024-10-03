package com.aayush209.javapractice.optionalexample.withoutoptional;

public class MainWithoutOptional {

    public static void main(String[] args) {
        Person person = new Person(null);

        //aim is to get city value from the person object if it is available or else print zero
        printCity(person);

        Address address2 = new Address("Chandigarh");
        person = new Person(address2);
        printCity(person);

    }

    private static void printCity(Person person) {
        String city = null;
        if(person != null){
            Address address = person.getAddress();
            if(address != null){
                city = address.getCity();
            }
        }

        System.out.println("City : " + (city != null ? city : "Unknown"));
    }

}

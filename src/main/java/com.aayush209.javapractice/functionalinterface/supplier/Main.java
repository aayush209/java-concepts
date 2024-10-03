package com.aayush209.javapractice.functionalinterface.supplier;

import java.util.UUID;
import java.util.function.Supplier;

public class Main {
    // takes no argument but returns a value when get() method is called
    /*
    @FunctionalInterface
    public interface Supplier<T> {


         * Gets a result.
         *
         * @return a result

            T get();
        }
    */
    public static void main(String[] args) {
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        System.out.println(uuidSupplier.get());
    }

}

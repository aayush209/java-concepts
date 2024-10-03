package com.aayush209.javapractice.functionalinterface;

public class ConcatenateStringTraditional implements ConcatenateString{

    @Override
    public String concatenate(String a, String b) {
        return a + " " + b;
    }

    public static void main(String[] args) {
        ConcatenateStringTraditional concatenateStringTraditional = new ConcatenateStringTraditional();
        System.out.println(concatenateStringTraditional.concatenate("asdfghjk", "45678"));
    }

}

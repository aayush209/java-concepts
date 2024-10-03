package com.aayush209.javapractice.functionalinterface;

public class RunnableExample {

    public static void main(String[] args) {
        //traditional way
        Runnable runnableObj1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        };

        //Implement using lambda
        Runnable runnableObj2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        };

        new Thread(runnableObj1, "thread1").start();
        new Thread(runnableObj2, "thread2").start();

        //Implement using thread with lambda
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "thread3").start();
    }
}

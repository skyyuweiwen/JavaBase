package com.terry.javabase.thread;

public class MyThreadB extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("Hello from MyThreadB, " + Thread.currentThread().getName());

        try {
            System.out.println("Thread " + Thread.currentThread().getName() + "go to sleep!");
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("interruppted! ");
        }
        System.out.println("Thread " + Thread.currentThread().getName() + "week up!");
    }
}

package com.terry.javabase.thread;

public class MyThreadA extends Thread{

    @Override
    public void run() {
        super.run();

        System.out.println("Hello from MyThreadA, " + Thread.currentThread().getName());
    }
}

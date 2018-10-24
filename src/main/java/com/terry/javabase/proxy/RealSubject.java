package com.terry.javabase.proxy;

public class RealSubject implements Subject{

    @Override
    public void rent() {
        System.out.println("I want rent a house.");
    }

    @Override
    public void hello(String str) {
        System.out.println("Hello: " + str);
    }
}

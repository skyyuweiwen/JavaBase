package com.terry.javabase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private final Object subject;

    public DynamicProxy(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before rent a house.");

        System.out.println("Method: " + method );

        method.invoke(subject, args);

        System.out.println("After ren a house.");

        return null;
    }
}

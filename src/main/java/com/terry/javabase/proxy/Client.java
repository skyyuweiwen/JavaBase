package com.terry.javabase.proxy;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class Client {

    public static void main(String[] args){
        Subject subject = new RealSubject();

        InvocationHandler handler = new DynamicProxy(subject);

        Subject subject1 = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass()
                .getInterfaces(), handler);

        System.out.println(subject1.getClass().getName());
        //subject1.rent();
        //subject1.hello("World");
        subject1.toString();

        //genProxyClass();
    }

    private static
    void genProxyClass() {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", RealSubject.class.getInterfaces());
        String path = "/home/terry/work/study/spring/JavaBase/Subject.class";

        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}

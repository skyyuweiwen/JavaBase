package com.terry.javabase.waitandnotify;

public class Consumer extends Thread {

    private int num;

    private AbstractStorage abstractStorage1;

    public  Consumer(AbstractStorage abstractStorage){
        this.abstractStorage1 = abstractStorage;
    }

    public void setNum(int num){
        this.num = num;
    }

    @Override
    public void run(){
        consume(num);
    }

    public void consume(int num) {
        abstractStorage1.consume(num);
    }
}

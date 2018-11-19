package com.terry.javabase.thread;

public
class MyThreadC extends Thread{

    @Override
    public
    void run() {

        int i = 0;
        while(!isInterrupted() && i<Integer.MAX_VALUE){
            System.out.println(i+" while循环");
            i++;
        }
    }
}

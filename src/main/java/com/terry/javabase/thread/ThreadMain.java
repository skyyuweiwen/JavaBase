package com.terry.javabase.thread;

import java.util.concurrent.TimeUnit;

public
class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new MyThreadA();
        Thread b = new MyThreadB();
        Thread c = new MyThreadC();

        Runnable ra = new RunnerA();
        Runnable rb = new RunnerB();
        Thread rc = new Thread(ra);
        rc.start();

        daemonThread(c);
        //interruptMethod(b, c);
        //joinMethod(a, b);
    }

    private static
    void daemonThread(Thread c) throws InterruptedException {
        c.setDaemon(true);
        c.start();
        TimeUnit.SECONDS.sleep(1);
    }

    private static
    void interruptMethod(Thread b, Thread c) {
        b.start();
        b.interrupt();
        c.start();
        try {
            c.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c.interrupt();
    }

    private static
    void joinMethod(Thread a, Thread b) {
        b.start();

        try {
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        a.start();
    }
}

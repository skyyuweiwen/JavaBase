package com.terry.javabase.locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain2 {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        final LockMain2 test = new LockMain2();

        new Thread() {
            public void run () {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            public void run () {
                test.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {

        lock.lock();
        try {
            System.out.println(thread.getName() + "get lock.");
            for (int i = 0; i < 100; i++) {
                arrayList.add(i);
            }
        }
        catch (Exception e) {
        }
        finally {
            System.out.println(thread.getName() + "free the lock.");
            lock.unlock();
        }

    }

}

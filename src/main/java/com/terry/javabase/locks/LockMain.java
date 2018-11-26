package com.terry.javabase.locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        final LockMain test = new LockMain();

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
        Lock lock = new ReentrantLock();
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

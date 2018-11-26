package com.terry.javabase.ThreadPools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolsMain {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i=0;i<15;i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("The thread number in the Thread pool:" + executor.getPoolSize() + ", the number is running; "
            + executor.getQueue().size() + "The number has been finish :" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

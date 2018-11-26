package com.terry.javabase.waitandnotify;

import java.util.LinkedList;

public class Storage1 implements AbstractStorage {

    private final int MAX_SIZE = 100;

    private LinkedList list = new LinkedList();

    @Override
    public void produce(int num) {
        synchronized (list){

            while (list.size() > MAX_SIZE){
                System.out.println("The target number to produce: " + num + "\t number in store"
                                    + list.size() + "\t not produce!");

                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i =0 ; i< num ; i++){
                list.add(new Object());
            }
            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
            list.notifyAll();
        }
    }

    @Override
    public void consume(int num) {
        synchronized (list){

            //不满足消费条件
            while(num > list.size()){
                System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行生产任务!");

                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //消费条件满足，开始消费
            for(int i=0;i<num;i++){
                list.remove();
            }

            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }
}

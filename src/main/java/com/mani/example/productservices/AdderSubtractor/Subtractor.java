package com.mani.example.productservices.AdderSubtractor;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
//    private Count c;
//    private Lock lock;
//    public Subtractor(Count c, Lock lock)
//    {
//        this.c = c;
//        this.lock = lock;
//    }
//
//    @Override
//    public void run() {
//        for(int i=1;i<=1000;i++)
//        {
//            lock.lock();
//            c.value -= i;
//            lock.unlock();
//        }
//    }
    private Count c;
    public Subtractor(Count c)
    {
        this.c = c;
    }

    @Override
    public void run() {
        for(int i=1;i<=1000;i++)
        {
            synchronized (this.c)
            {
                this.c.value -= i;
            }
        }
    }
}
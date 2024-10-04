package com.mani.example.productservices.AdderSubtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Driver {
    public static void main(String[] args) {

//        Lock lock = new ReentrantLock();
//
//        Count c = new Count();
//        Adder adder = new Adder(c,lock);
//        Subtractor subtractor = new Subtractor(c,lock);
//
//        Thread t1 = new Thread(adder);
//        Thread t2 = new Thread(subtractor);
//
//        t1.start();
//        t2.start();
//
//        System.out.println(c.value);
        Count c = new Count();
        Adder adder = new Adder(c);
        Subtractor subtractor = new Subtractor(c);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        System.out.println(c.value);
    }
}

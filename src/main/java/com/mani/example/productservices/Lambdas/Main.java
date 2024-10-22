package com.mani.example.productservices.Lambdas;

public class Main {
    public static void main(String[] args) {

        //this is anonymous class syntax
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am anonymous class only");
            }
        };


        //this is lambda syntax
        Runnable r2 = () -> System.out.println("I am lambda now");

        A a = (num)->{
            System.out.println("I a inside show this is num: " +num);
        };
        a.show(10);

        B b = (num1, num2) ->{
            System.out.println("I am anonymous class only: " +num1+num2);
        };
        b.show(10,10);
    }
}
interface A{
    void show(int n);
}

interface B {
    void show(int n, int m);
}
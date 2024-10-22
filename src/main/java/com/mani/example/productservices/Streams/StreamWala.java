package com.mani.example.productservices.Streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

public class StreamWala {
    /*
    * I have an array of some numbers.
    * I want to do some operations like this
    * 1. Remove all the odd numbers O(n)
    * 2. square the remaining numbers O(n)
    * 3. sort the array O(NLogN)
    * 4. remove duplicates O(n)
    * 5. print the final output O(n)
    * */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 33, 1, 5, 78, 55, 20, 4, 8, 4, 70);
        HashSet<Integer> set = new HashSet<>();

        for (int number : list) {
            if (number % 2 == 0) {
                int sqrt = number * number;
                set.add(sqrt);
            }
        }

        List<Integer> modifiedList = new ArrayList<>(set);
        Collections.sort(modifiedList);

        for (int num : modifiedList) {
            System.out.println(num + " ");
        }

        System.out.println("*******************************");

        list.stream()
                .filter(num -> num % 2 == 0)
                .map(num->num*num)
                .sorted()
                .distinct()
                .forEach(num -> System.out.println(num + " "));

        List<String> list1 = Arrays.asList("Sonu","Monu","Ravi","Anshu","Vicky");
        /*
        * count all the letters in a string and square it sort it and create a new array and print it
        * */

        System.out.println("**********************************");
        List<Integer> l = list1.stream()
                .map(n->n.length())
                .map(n->n*n)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(l);
    }
}

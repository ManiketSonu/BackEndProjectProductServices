package com.mani.example.productservices.Builder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DemoOne {
    public static void main(String arg[])
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(1);

        LinkedList<Integer> list1 = new LinkedList<>();
        list.add(7);
        list.add(2);
        list.add(8);

//        LinkedList<Integer> result = new LinkedList<>();
//        if(list.size()==list1.size())
//        {
//            for(int i=0;i<list1.size();i++)
//            {
//                int sum1=list.get(i)+list1.get(i);
//                result.add(sum1);
//            }
//            System.out.println(result);
//        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();;

        LinkedList<Integer> result = new LinkedList<>();
        for(int i=0;i<list.size();i++)
        {
            if(!stack.isEmpty()) {
                stack.pop();
            }
            else
            {
                stack.push(list.get(i));
            }
        }

        for(int i=0;i<list1.size();i++)
        {
            if(!stack1.isEmpty()) {
                stack1.pop();
            }
            else
            {
                stack1.push(list1.get(i));
            }
        }


    }
}

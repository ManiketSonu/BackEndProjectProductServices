package com.mani.example.productservices.ExceptionHandling;

import java.io.IOException;

public class client {
    public static void main(String[] args) throws IOException {
        Driver d = new Driver();


        try
        {
            System.out.println(d.divideGivenNumber(100));
            System.out.println(d.divideGivenNumber(50));
            System.out.println(d.divideGivenNumber(0));
            Driver.createFile("file created");
        }

        //we can create catch block as much as we want but  it is not good way to handle the exception
        //what we can do we can use parent here i.e "Exception"
//        catch (IOException e)
//        {
//            System.out.println("catching the exception");
//        }
//        catch (ArithmeticException e)
//        {
//            System.out.println("Arithmetic exception");
//        }

        catch (Exception e)
        {
            System.out.println("catching the exception:");
        }

        System.out.println("Done with the flow");
    }
}

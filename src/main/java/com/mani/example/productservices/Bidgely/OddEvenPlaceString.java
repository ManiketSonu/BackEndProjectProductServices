package com.mani.example.productservices.Bidgely;

import java.util.Arrays;

public class OddEvenPlaceString {
    public static void main(String[] args) {
        String st1 = "Geeks";
        String st2 = "skeeG";
        String result = oddEvenPlaceString(st1, st2);
        System.out.println(result);
    }
    public static String oddEvenPlaceString(String st1, String st2) {
        if(st1.length()!=st2.length()) {
            return "No";
        }
        char odd1[] = new char[(st1.length()+1)/2];
        char even1[] = new char[st1.length()/2];
        char odd2[] = new char[(st2.length()+1)/2];
        char even2[] = new char[st2.length()/2];

        for(int i=0;i<st1.length();i++) {
            if(i%2==0) {
                even1[i / 2] = st1.charAt(i);
                even2[i / 2] = st2.charAt(i);
            }
            else
            {
                odd1[i/2] = st1.charAt(i);
                odd2[i/2] = st2.charAt(i);
            }
        }
        Arrays.sort(odd1);
        Arrays.sort(odd2);
        Arrays.sort(even1);
        Arrays.sort(even2);

        if(Arrays.equals(odd1,odd2) && Arrays.equals(even1,even2)){
                return "Yes";
        }
        else
        {
            return "No";
        }
    }
}

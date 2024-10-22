package com.mani.example.productservices.Bidgely;

import java.util.Arrays;

public class UnformableNumber {
    public static void main(String[] args) {
        String s = "1,2,2,3,10";
        int res = solve(s);
        System.out.println(res);
    }
    public static int solve(String s)
    {
        String str[] = s.split(",");
        int numbers[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i].trim());
        }
        Arrays.sort(numbers);
        int smallNo = 1;
        for(int number:numbers)
        {
            if(number>smallNo)
            {
                break;
            }
            smallNo = smallNo+number;
        }
        return smallNo;
    }
}

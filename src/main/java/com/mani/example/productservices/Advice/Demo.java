package com.mani.example.productservices.Advice;

public class Demo {
    public static void main(String[] args) {
        String str = "abcdedcba";
        String result = palindromeString(str);
        for(int i=0;i<result.length();i++)
        {
            System.out.print(result.charAt(i)+" ");
//            System.out.println();
        }
    }
    public static String palindromeString(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(n);
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                String str1 = str.substring(i,j+1);
                if(isPlindrom(str1))
                {
                    sb.append(str1);
                }
            }
        }
        return sb.toString();
    }
    public static boolean isPlindrom(String str)
    {
        int n = str.length();
        int low = 0;
        int high = n-1;
        while (low<high)
        {
            if(str.charAt(low)!=str.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}

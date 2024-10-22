package com.mani.example.productservices.Bidgely;

public class CountNumberOfPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aba";
        int count = countSubstring(s);
        System.out.println(count);
    }
    public static int countSubstring(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                String substr = s.substring(i, j+1);
                if(palindrome(substr))
                {
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean palindrome(String str)
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

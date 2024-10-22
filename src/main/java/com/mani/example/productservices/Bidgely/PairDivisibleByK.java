package com.mani.example.productservices.Bidgely;

import java.util.HashSet;

public class PairDivisibleByK {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(solve(arr, 6));
    }
//    public static boolean solve(int arr[], int k)
//    {
//        int n = arr.length;
//        for(int i=0;i<n;i++)
//        {
//            for(int j=i+1;j<n;j++)
//            {
//                int sum = arr[i]+arr[j];
//                if(sum%k==0)
//                {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public static boolean solve(int[] arr, int k) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int remainder = (arr[i]%k+k)%k;
            int complement = (k-remainder)%k;
            if(hs.contains(complement))
            {
                return true;
            }
            hs.add(remainder);
        }
        return false;
    }

}

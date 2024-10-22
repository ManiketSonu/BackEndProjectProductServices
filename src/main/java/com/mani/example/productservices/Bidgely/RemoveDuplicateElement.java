package com.mani.example.productservices.Bidgely;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        int arr[] = {10,70,30,90,20,20,30,40,70,50};
//        int res = removeDuplicates(arr);
//        System.out.println(Arrays.toString(Arrays.copyOf(arr, res+1)));
        int res[] = removeDuplicates(arr);
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
//    public static int removeDuplicates(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        int j = 0;
//        for(int i=1; i<n; i++) {
//            if(nums[i] != nums[j]) {
//                j++;
//                nums[j] = nums[i];
//            }
//        }
//        return j;
//    }
    public static int[] removeDuplicates(int[] arr) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            hs.add(arr[i]);
        }

        int j = 0;
        int result[] = new int[hs.size()];
        for(int num :hs)
        {
            result[j] = num;
            j++;
        }
        return result;
    }
}

package com.mani.example.productservices.Bidgely;

public class ContainsPositiveNegativeNumberMaxSum {
    public static void main(String[] args) {
        int arr[] = {-1,9,4,5,-4,7};
        int result = sum(arr);
        System.out.println(result);
    }
    public static int sum(int arr[])
    {
        int n = arr.length;
        int maxSum = 0;
        for(int i=n-1;i>0;i = i-2)
        {
            if(arr[i]>0 && arr[i-1]>0)
            {
                maxSum = maxSum+arr[i]*arr[i-1];
            }
            else if(arr[i]>0)
            {
                maxSum = maxSum+arr[i];
                break;
            }
        }

        for(int j=0;j<n-1;j++)
        {
            if(arr[j]<0 && arr[j+1]<0)
            {
                maxSum = maxSum+arr[j]*arr[j+1];
            }
            else if(arr[j]<0)
            {
                maxSum = maxSum+arr[j];
                break;
            }
        }
        return maxSum;
    }
}

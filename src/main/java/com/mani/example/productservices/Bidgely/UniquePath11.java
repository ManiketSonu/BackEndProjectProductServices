package com.mani.example.productservices.Bidgely;

public class UniquePath11 {
    public static void main(String[] args) {
        int arr[][] = {{0,0,0},
                        {0,1,0},
                        {0,0,0}};

        int result = uniquePathsWithObstacles(arr);
        System.out.println(result);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            if(obstacleGrid[i][0] == 1)
            {
                break;
            }
            dp[i][0] = 1;
        }
        for(int j=0;j<m;j++)
        {
            if(obstacleGrid[0][j] == 1)
            {
                break;
            }
            dp[0][j] = 1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}

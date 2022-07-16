package leetcodeJava;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        var dp = new double[101][101];
        var p = (double) poured;
        dp[0][0] = p;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = Math.max(0, (dp[i-1][j]-1)/2);
                else if (j == i) 
                    dp[i][j] = Math.max(0, (dp[i-1][j-1]-1)/2);
                else 
                    dp[i][j] = Math.max(0, (dp[i-1][j-1]-1)/2) + Math.max(0, (dp[i-1][j]-1)/2);
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }
}

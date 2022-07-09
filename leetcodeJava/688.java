package leetcodeJava;

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        var dp = new double[n][n][k+1];
        for (var a : dp)
            for (var aa : a)
                Arrays.fill(aa, -1);
        return solve(dp, k, row, column);
    }
    
    // dfs with dp
    private double solve(double[][][] dp, int k, int i, int j) {
        var n = dp.length;
        if (i < 0 || i >= n || j < 0 || j >= n) return 0;
        if (k == 0) return 1;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        double res = 0;
        res += 1.0/8 * solve(dp, k-1, i-2, j+1);
        res += 1.0/8 * solve(dp, k-1, i-1, j+2);
        res += 1.0/8 * solve(dp, k-1, i+1, j+2);
        res += 1.0/8 * solve(dp, k-1, i+2, j+1);
        res += 1.0/8 * solve(dp, k-1, i+2, j-1);
        res += 1.0/8 * solve(dp, k-1, i+1, j-2);
        res += 1.0/8 * solve(dp, k-1, i-1, j-2);
        res += 1.0/8 * solve(dp, k-1, i-2, j-1);
        dp[i][j][k] = res;
        return res;
    }
}

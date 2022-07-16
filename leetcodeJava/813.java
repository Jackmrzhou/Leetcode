package leetcodeJava;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        var n = nums.length;
        var dp = new double[n+1][k+1];
        var preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            dp[i+1][1] = (double)preSum / (i+1);
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < j; l++) {
                    var sum = 0;
                    for (int m = l; m < j; m++)
                        sum += nums[m];
                    double avg = sum * 1.0 / (j-l);
                    dp[j][i] = Math.max(dp[l][i-1] + avg, dp[j][i]);
                }
            }
        }
        double res = 0;
        for (int i = 1; i <= k; i++) res = Math.max(res, dp[n][i]);
        return res;
    }
}

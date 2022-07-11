package leetcodeJava;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (var n : nums) {
            max = Math.max(max, n);
        }
        var sum = new int[max+1];
        for (var n : nums) sum[n] += n;
        var dp = new int[2];
        dp[0] = sum[0];
        dp[1] = Math.max(dp[0], sum[1]);
        for (int i = 2; i <= max; i++) {
            var tmp = Math.max(dp[1], dp[0] + sum[i]);
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return dp[1];
    }
}

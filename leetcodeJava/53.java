package leetcodeJava;

import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        var dp = new int[nums.length];
        Arrays.fill(dp, -10001);
        dp[0] = nums[0];
        for (var i = 1; i < nums.length; i++) {
            var v = dp[i-1] + nums[i];
            if (nums[i] > v) {
                dp[i] = nums[i];
            } else {
                dp[i] = v;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
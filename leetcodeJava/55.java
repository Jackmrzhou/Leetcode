package leetcodeJava;

class Solution {
    public boolean canJump(int[] nums) {
        var dp = new boolean[nums.length];
        dp[0] = true;
        for (var i = 0; i < nums.length; i++) {
            if (dp[i] == false) continue;
            for (var j = 1; j <= nums[i]; j++) {
                if (i+j >= dp.length)
                    return true;
                else
                    dp[i+j] = (dp[i] || dp[i+j]);
            }
        }
        return dp[dp.length-1];
    }
}
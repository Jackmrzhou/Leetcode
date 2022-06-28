func jump(nums []int) int {
	dp := make([]int, len(nums))
	for i := 1; i < len(dp); i++ {
		for j := 1; j <= nums[i-1]; j++ {
			if i+j-1 < len(dp) && (dp[i+j-1] == 0 || dp[i+j-1] > 1+dp[i-1]) {
				dp[i+j-1] = 1 + dp[i-1]
			}
		}
	}
	return dp[len(dp)-1]
}
object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = {
        val dp = Array.fill(nums.length)(1)
        for (i <- 1 until nums.length; j <- 0 until i) {
            if (nums(i) > nums(j)) {
                dp(i) = dp(i).max(1 + dp(j))
            }
        }
        dp.max
    }
}
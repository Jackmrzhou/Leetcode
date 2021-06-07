object Solution {
    def rob(nums: Array[Int]): Int = {
        if (nums.length == 1) return nums.head
        val dp = Array.ofDim[Int](nums.length, 2)
        dp(0)(0) = nums.head
        dp(0)(1) = 0
        for (i <- 1 until nums.length) {
            if (i == 1) {
                dp(i)(0) = dp(i-1)(0)
                dp(i)(1) = nums(i)
            } else {
                if (i == 2) dp(i)(1) = dp(i-1)(1).max(nums(i))
                else dp(i)(1) = dp(i-1)(1).max(dp(i-2)(1) + nums(i))
                if (i < nums.length - 1) dp(i)(0) = dp(i-1)(0).max(dp(i-2)(0) + nums(i))
            }
        }
        dp(nums.length-2)(0).max(dp.last.last)
    }
}
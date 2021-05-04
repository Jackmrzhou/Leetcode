object Solution {
    def rob(nums: Array[Int]): Int = {
      val dp = Array.ofDim[Int](nums.length)
      if (nums.length == 1) return nums(0)
      dp(0) = nums(0)
      if (nums.length == 2) return nums(0).max(nums(1))
      dp(1) = nums(1)
      for (i <- 2 until nums.length) {
        dp(i) = dp(i-1).max(dp(i-2)) + nums(i)
      }
      dp.last
    }
}

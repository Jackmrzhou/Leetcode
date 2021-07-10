object Solution {
    def wiggleMaxLength(nums: Array[Int]): Int = {
        val dp = Array.fill(nums.length, 2)(1)
        for (i <- 1 until nums.length; j <- 0 until i) {
            if (nums(i) > nums(j))
                dp(i)(0) = dp(i)(0).max(dp(j)(1)+1)
            else if (nums(i) < nums(j))
                dp(i)(1) = dp(i)(1).max(dp(j)(0)+1)
        }
        dp(nums.length-1)(0).max(dp(nums.length-1)(1))
    }
}
object Solution {
    def findNumberOfLIS(nums: Array[Int]): Int = {
        val dp = Array.fill(nums.length)(Array(1, 1))
        for (i <- 0 until dp.length; j <- 0 until i){
            if (nums(i) > nums(j)) {
                if (dp(j)(0) + 1 > dp(i)(0)) {
                    dp(i)(0) = dp(j)(0) + 1
                    dp(i)(1) = dp(j)(1)
                } else if (dp(j)(0) + 1 == dp(i)(0)) {
                    dp(i)(1) += dp(j)(1)
                }
            }
        }
        val max = dp.maxBy(_.head).head
        dp.foldLeft(0){
            case (sum, arr) => if (arr.head == max) sum + arr.last else sum
        }
    }
}
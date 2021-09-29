import scala.collection.mutable.Stack
object Solution {
    def checkPossibility(nums: Array[Int]): Boolean = {
        val dp = Array.ofDim[Int](nums.length)
        dp(0) = 1
        for (i <- 0 until nums.length) {
            dp(i) = 1
            for (j <- 0 until i)
                if (nums(i) >= nums(j)) dp(i) = dp(i).max(dp(j)+1)
        }
        dp.max >= nums.length-1
    }
}
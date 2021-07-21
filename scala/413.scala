import scala.collection.mutable
object Solution {
    def numberOfArithmeticSlices(nums: Array[Int]): Int = {
        val dp = Array.ofDim[Int](nums.length)
        if(nums.length < 3) 0
        else {
            var res = 0
            for (i <- 2 until nums.length) {
                if (nums(i) - nums(i-1) == nums(i-1) - nums(i-2)) {
                    dp(i) = dp(i-1) + 1
                    res += dp(i)
                }
            }
            res
        }
    }
}
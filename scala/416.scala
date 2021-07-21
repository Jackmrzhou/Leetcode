import scala.collection.mutable
object Solution {
    def canPartition(nums: Array[Int]): Boolean = {
        val sum = nums.sum
        if (sum % 2 != 0) false
        else {
            val s = sum / 2
            val dp = Array.fill(s+1)(false)
            dp(0) = true
            nums.foreach(n => {
                for (i <- s to n by -1) {
                    dp(i) = dp(i) || dp(i-n)
                }
            })
            dp.last
        }
    }
}
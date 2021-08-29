import scala.collection.mutable
object Solution {
    def subarraySum(nums: Array[Int], k: Int): Int = {
        var preSum = 0
        val map = mutable.Map[Int, Int]()
        var res = 0
        for (i <- 0 until nums.length) {
            preSum += nums(i)
            if (preSum == k) res += 1
            if (map.contains(preSum-k)) {
                res += map(preSum - k)
            }
            if (!map.contains(preSum)) {
                map += (preSum -> 1)
            } else {
                map(preSum) += 1
            }
        }
        res
    }
}
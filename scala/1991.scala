object Solution {
    def findMiddleIndex(nums: Array[Int]): Int = {
        val preSum = Array.ofDim[Int](nums.length)
        var sum = 0
        for (i <- 0 until nums.length) {
            sum += nums(i)
            preSum(i) = sum
        }
        for (i <- 0 until nums.length) {
            if (preSum.last - preSum(i) == preSum(i)-nums(i)) return i
        }
        -1
    }
}
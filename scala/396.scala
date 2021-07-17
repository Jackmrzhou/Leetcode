object Solution {
    def maxRotateFunction(nums: Array[Int]): Int = {
        val f = Array.ofDim[Int](nums.length)
        f(0) = 0
        var sum = 0
        for (i <- 0 until nums.length) {
            val n = nums(i)
            f(0) += i * n
            sum += n
        }
        val n = nums.length
        for (i <- 1 until nums.length) {
            f(i) = (f(i-1).toLong + sum - n*nums(n-i)).toInt
        }
        f.max
    }
}
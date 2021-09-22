object Solution {
    def findMaxAverage(nums: Array[Int], k: Int): Double = {
        def loop(i: Int, sum: Int, best: Int): Double = {
            if (i == nums.length) best / k.toDouble
            else {
                val newSum = sum - nums(i - k) + nums(i)
                loop(i + 1, newSum, math.max(best, newSum))
            }
        }
        
        val sum = nums.slice(0, k).sum
        
        loop(k, sum, sum)
    }
}

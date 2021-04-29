object Solution {
    def missingNumber(nums: Array[Int]): Int = {
      val expectSum = (1+nums.length)*nums.length / 2
      expectSum - nums.sum
    }
}

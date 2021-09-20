object Solution {
    def maximumProduct(nums: Array[Int]): Int = {
        val sorted = nums.sorted
        val n = nums.length
        (sorted(0)*sorted(1)*sorted.last).max(sorted(n-1)*sorted(n-2)*sorted(n-3))
    }
}
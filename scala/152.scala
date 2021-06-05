object Solution {
    def maxProduct(nums: Array[Int]): Int = {
        (1 until nums.length).foldLeft((nums.head, nums.head, nums.head)) {
            case ((min, max, res), i) => {
                val n = nums(i)
                val newMin = n.min(min*n).min(max*n)
                val newMax = n.max(max*n).max(min*n)
                (newMin, newMax, res.max(newMax))
            }
        }._3
    }
}
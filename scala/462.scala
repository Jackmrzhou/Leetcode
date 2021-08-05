import java.util.Arrays
object Solution {
    def minMoves2(nums: Array[Int]): Int = {
        Arrays.sort(nums)
        val mid = nums(nums.length/2)
        nums.foldLeft(0) {
            case (sum, n) => sum + (n-mid).abs
        }
    }
}
import java.util.Arrays
object Solution {
    def findDuplicate(nums: Array[Int]): Int = {
        Arrays.sort(nums)
        for (i <- 1 until nums.length)
            if (nums(i) == nums(i-1))
                return nums(i)
        -1
    }
}
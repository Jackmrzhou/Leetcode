import java.util.Arrays
object Solution {
    def triangleNumber(nums: Array[Int]): Int = {
        Arrays.sort(nums)
        var res = 0
        for (i <- 0 until nums.length-2; if (nums(i) != 0)) {
            var k = i + 2
            for (j <- i+1 until nums.length-1) {
                while (k < nums.length && nums(i)+nums(j) > nums(k)) {
                    k += 1
                }
                res += k-j-1
            }
        }
        res
    }
}
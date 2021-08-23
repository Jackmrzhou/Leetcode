import java.util.Arrays
object Solution {
    def findPairs(nums: Array[Int], k: Int): Int = {
        Arrays.sort(nums)
        var res = 0
        var i = 0
        while (i < nums.length) {
            var j = i + 1
            while (j < nums.length && (nums(i)-nums(j)).abs <= k) {
                if ((i==0 || nums(i-1) != nums(i)) && (j==i+1||nums(j-1) != nums(j)) && (nums(i)-nums(j)).abs == k) res += 1
                j += 1
            }
            i += 1
        }
        res
    }
}
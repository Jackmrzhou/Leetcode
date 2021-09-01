object Solution {
    def findUnsortedSubarray(nums: Array[Int]): Int = {
        val sorted = nums.sorted
        var l = 0
        var r = nums.length-1
        while (l < nums.length && nums(l) == sorted(l)) {
            l += 1
        }
        while (r >= 0 && nums(r) == sorted(r)) {
            r -= 1
        }
        if (r-l<=0) 0
        else r-l+1
    }
}
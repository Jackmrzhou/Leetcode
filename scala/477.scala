object Solution {
    def totalHammingDistance(nums: Array[Int]): Int = {
        var res = 0
        for (i <- 0 until 32) {
            var ones = 0
            var zeros = 0
            for (j <- 0 until nums.length) {
                if((nums(j) & 1) == 1) ones += 1
                else zeros += 1
                nums(j) >>= 1
            }
            res += ones * zeros
        }
        res
    }
}
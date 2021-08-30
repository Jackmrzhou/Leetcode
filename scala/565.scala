object Solution {
    def arrayNesting(nums: Array[Int]): Int = {
        var res = 0
        for (i <- 0 until nums.length; if (nums(i) >= 0)) {
            var counter = 1
            var next = nums(i)
            nums(i) = -1
            while (nums(next) >= 0) {
                val tmp = next
                next = nums(next)
                nums(tmp) = -1
                counter += 1
            }
            res = res.max(counter)
        }
        res
    }
}
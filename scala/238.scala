object Solution {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        var zeros = 0
        var p = 1
        for (n <- nums) {
            if (n == 0) {
                zeros += 1
                if (zeros > 1) p = 0
            }
            else p *= n
        }
        if (zeros > 1) {
            Array.fill(nums.length)(0)
        } else {
            val res = Array.ofDim[Int](nums.length)
            for (i <- 0 until nums.length) {
                if (nums(i) == 0) res(i) = p
                else if (zeros != 0) res(i) = 0
                else res(i) = p / nums(i)
            }
            res
        }
    }
}
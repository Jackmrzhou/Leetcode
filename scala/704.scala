object Solution {
    def search(nums: Array[Int], target: Int): Int = {
        def f(i: Int, j: Int): Int = {
            if (i >= j) {
                if (nums(i) == target) i
                else -1
            } else {
                val mid = i + (j-i)/2
                if (nums(mid) >= target) f(i, mid)
                else f(mid+1, j)
            }
        }
        f(0, nums.length-1)
    }
}
object Solution {
    def combinationSum4(nums: Array[Int], target: Int): Int = {
        val mem = Array.fill(1000)(-1)
        def dfs(n: Int): Int = {
            if (n < 0) 0
            else if (n == 0) 1
            else if (mem(n) != -1) mem(n)
            else {
                val total = (0 until nums.length).foldLeft(0) {
                    case (t, i) => t + dfs(n - nums(i))
                }
                mem(n) = total
                total
            }
        }
        dfs(target)
    }
}
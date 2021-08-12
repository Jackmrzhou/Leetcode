import scala.collection.mutable
object Solution {
    def findTargetSumWays(nums: Array[Int], target: Int): Int = {
        val mem = mutable.Map[Tuple2[Int, Int], Int]()
        def dfs(i: Int, sum: Int): Int = {
            if (mem.contains((i, sum))) {
                mem((i, sum))
            } else if (i == nums.length) {
                if (sum == target) 1
                else 0
            } else {
                val res = dfs(i+1, sum + nums(i)) + dfs(i+1, sum - nums(i))
                mem += ((i, sum) -> res)
                res
            }
        }
        dfs(0, 0)
    }
}
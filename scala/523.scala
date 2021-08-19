import scala.collection.mutable
object Solution {
    def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
        val map = mutable.Map[Int, Int]()
        var pre = 0
        for (i <- 0 until nums.length) {
            pre += nums(i)
            val tmp = pre % k
            if (i != 0 && tmp == 0) return true
            if (map.contains(tmp)) {
                if (i-map(tmp)>1) return true
            } else {
                map += (tmp -> i)
            }
        }
        false
    }
}
import scala.collection.mutable
object Solution {
    def findMaxLength(nums: Array[Int]): Int = {
        val map = mutable.Map[Int, Int]((0, -1))
        var pre = 0
        var res = 0
        for (i <- 0 until nums.length) {
            if (nums(i) == 0) pre += -1 else pre += 1
            if (map.contains(pre)) {
                res = res.max(i-map(pre))
            } else {
                map += (pre -> i)
            }
        }
        res 
    }
}
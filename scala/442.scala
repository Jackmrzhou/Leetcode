import scala.collection.mutable.ListBuffer
object Solution {
    def findDuplicates(nums: Array[Int]): List[Int] = {
        val res = ListBuffer[Int]()
        for (i <- 0 until nums.length) {
            val tmp = nums(i).abs
            if (nums(tmp-1) < 0) res += tmp
            else nums(tmp - 1) *= -1
        }
        res.toList
    }
}
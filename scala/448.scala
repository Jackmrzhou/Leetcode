import scala.collection.mutable.ListBuffer
object Solution {
    def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
        for (n <- nums) {
            var i = n - 1
            while(nums(i) != i+1) {
                val tmp = nums(i)
                nums(i) = i+1
                i = tmp-1
            }
        }
        val res = ListBuffer[Int]()
        for (i <- 0 until nums.length) {
            if (nums(i) != i+1) res += i+1
        }
        res.toList
    }
}
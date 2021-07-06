import java.util.Arrays
import scala.collection.mutable.ListBuffer
object Solution {
    def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
        val count = Array.fill(nums.length)(0)
        val pre = Array.fill(nums.length)(0)
        Arrays.sort(nums)
        for (i <- 0 until nums.length) {
            pre(i) = i
            count(i) = 1
            for (j <- i-1 to 0 by -1) {
                if (nums(i) % nums(j) == 0 && count(j) >= count(i)) {
                    count(i) = count(j) + 1
                    pre(i) = j
                }
            }
        }
        var i = count.indexOf(count.max)
        val res = ListBuffer[Int]()
        while ( i != pre(i)) {
             res += nums(i)
             i = pre(i)
        }
        res += nums(i)
        res.toList
    }
}
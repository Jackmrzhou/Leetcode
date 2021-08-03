import java.util.Arrays
import java.util.PriorityQueue
object Solution {
    def fourSumCount(nums1: Array[Int], nums2: Array[Int], nums3: Array[Int], nums4: Array[Int]): Int = {
        val map = nums1.foldLeft(Map[Int, Int]()) {
            case (m, num) => {
                if (m.contains(num)) m + (num -> (m(num) + 1))
                else m + (num -> 1)
            }
        }
        val n = nums4.length
        var res = 0
        for (i <- 0 until n; j <- 0 until n; k <- 0 until n) {
            map.get(-(nums2(i)+nums3(j)+nums4(k))) match {
                case Some(v) => res += v
                case _ =>
            }
        }
        res
    }
}
import scala.collection.mutable
object Solution {
    def longestConsecutive(nums: Array[Int]): Int = {
        val m = mutable.Map[Int, Int]() 
        nums.foreach(p => m(p) = 1)
        nums.foldLeft(0) {
            case (max, n) => {
                if (m(n) == -1) {
                    max
                } else {
                    var i = n-1
                    var count = 0
                    while (m.contains(i) && m(i) != -1) {
                        count += 1
                        m(i) = -1
                        i -= 1
                    }
                    i = n+1
                    while(m.contains(i) && m(i) != -1) {
                        count += 1
                        m(i) = -1
                        i += 1
                    }
                    m(n) = -1
                    max.max(count+1)
                }
            }
        }
    }
}
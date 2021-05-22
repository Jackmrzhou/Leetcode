import scala.collection.mutable.ListBuffer
object Solution {
    def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
        val i = intervals.lastIndexWhere(p => p.head < newInterval.head)       
        val arr = if (i == -1) {
            newInterval +: intervals
        } else {
            Array(intervals(i), newInterval) ++ intervals.slice(i+1, intervals.length)
        }
        def overlap(arr1: Array[Int], arr2: Array[Int]): Boolean = {
            return arr1.last >= arr2.head
        } 
        val res = ListBuffer[Array[Int]]()
        (arr :+ Array(100001, 100001)).foldLeft(arr.head) {
            case (last, cur) => {
                if (overlap(last, cur)) {
                    last(1) = math.max(last.last, cur.last)
                    last
                } else {
                    res += last
                    cur
                }
            }
        }
        intervals.slice(0, i) ++ res.toArray
    }
}
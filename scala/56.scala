import scala.collection.mutable.ListBuffer
object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        val sorted = intervals.sortBy(arr => arr.head)
        def overlap(arr1: Array[Int], arr2: Array[Int]): Boolean = {
            return arr1.last >= arr2.head
        } 
        val res = ListBuffer[Array[Int]]()
        (sorted :+ Array(10001, 10001)).foldLeft(sorted.head) {
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
        res.toArray
    }
}
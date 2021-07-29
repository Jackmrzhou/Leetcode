import java.util.Arrays
import java.util.Comparator
object Solution {
    def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
        Arrays.sort(intervals, Ordering.by[Array[Int], Int](arr => arr.last))
        var res = 1
        var end = 0
        for (i <- 1 until intervals.length; if intervals(i)(0) >= intervals(end)(1)) {
            end = i
            res += 1
        }
        intervals.length - res
    }
}
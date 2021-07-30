object Solution {
    def findRightInterval(intervals: Array[Array[Int]]): Array[Int] = {
        val sorted = intervals.zipWithIndex.sortBy(p => p._1.head)
        def search(l: Int, r: Int, end: Int): Int = {
            if (l > r) -1
            else {
                val mid = l + (r-l)/2
                if (l == r) {
                    if (sorted(l)._1.head >= end) sorted(l)._2
                    else -1
                }
                else if (sorted(mid)._1.head < end) search(mid+1, r, end)
                else search(l, mid, end)
            }
        }
        intervals.map(arr => search(0, sorted.length-1, arr.last)).toArray
    }
}
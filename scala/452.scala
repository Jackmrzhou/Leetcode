object Solution {
    def findMinArrowShots(points: Array[Array[Int]]): Int = {
        val sorted = points.sortBy(p => p.head)
        var i = 0
        var count = 0
        while (i < sorted.length) {
            var end = sorted(i).last
            while (i < sorted.length && sorted(i).head <= end) {
                if (sorted(i).last < end) end = sorted(i).last
                i += 1
            }
            count += 1
        }
        count
    }
}
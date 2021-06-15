object Solution {
    def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
        var start = timeSeries.head
        var end = timeSeries.head + duration
        var res = 0
        for (t <- timeSeries) {
            if (t >= end) {
                res += end - start
                start = t
                end = start + duration
            } else {
                end = t + duration
            }
        }
        res + end - start
    }
}
object Solution {
    def findMinDifference(timePoints: List[String]): Int = {
        val arr = timePoints.map(str => {
            val arr = str.split(":").map(s => s.toInt)
            arr.head*60+arr.last
        }).sorted
        var res = arr.head + (24*60 - arr.last)
        for (i <- 1 until arr.length) {
            res = res.min(arr(i)-arr(i-1))
        }
        res
    }
}
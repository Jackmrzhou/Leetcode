object Solution {
    def minimumTotal(triangle: List[List[Int]]): Int = {
        val arr = triangle.map(l => l.toArray).toArray
        for (i <- 1 until arr.length) {
            for (j <- 0 until arr(i).length) {
                if (j == 0) arr(i)(j) += arr(i-1)(0)
                else if (j==arr(i).length-1) arr(i)(j) += arr(i-1)(j-1)
                else arr(i)(j) += arr(i-1)(j).min(arr(i-1)(j-1))
            }
        }
        arr.last.min
    }
}
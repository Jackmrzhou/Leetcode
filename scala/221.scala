object Solution {
    def maximalSquare(matrix: Array[Array[Char]]): Int = {
        val dp = Array.ofDim[Int](matrix.length, matrix.head.length) 
        var res = 0
        for (i <- 0 until matrix.length) {
            dp(i)(0) = matrix(i)(0) - '0'
            res = res.max(dp(i)(0))
        }
        for (j <- 0 until matrix.head.length) {
            dp(0)(j) = matrix(0)(j) - '0'
            res = res.max(dp(0)(j))
        }
        for (i <- 1 until matrix.length; j <- 1 until matrix.head.length) {
            if (matrix(i)(j) == '1')
              dp(i)(j) = dp(i-1)(j).min(dp(i-1)(j-1)).min(dp(i)(j-1)) + 1
            else dp(i)(j) = 0
            res = res.max(dp(i)(j))
        }
        res*res
    }
}
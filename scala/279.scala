object Solution {
    def numSquares(n: Int): Int = {
        if (n == 1) return 1
        if (n == 2) return 2
        val dp = Array.fill(n+1)(0)
        dp(0) = 0
        dp(1) = 1
        for (i <- 1 to n; j <- 1 to math.sqrt(i).toInt) {
            if (dp(i) == 0) dp(i) = 1 + dp(i-j*j)
            else dp(i) = dp(i).min(1 + dp(i-j*j))
        }
        dp.last
    }
}
object Solution {
    def integerBreak(n: Int): Int = {
        val dp = Array.fill(n+1)(0)
        dp(1) = 1
        for (i <- 2 to n; j <- 1 until i) {
            val x = if (dp(j) < j) j else dp(j)
            val y = if (dp(i-j) < i-j) i-j else dp(i-j)
            dp(i) = dp(i).max(x*y)
        }
        dp.last
    }
}
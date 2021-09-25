object Solution {
    def minSteps(n: Int): Int = {
        val dp = Array.ofDim[Int](n+1)
        dp(1) = 0
        for (i <- 1 to n) {
            for(j <- i to n-i by i) {
                if (j == i) dp(j) += 1
                dp(j+i) = dp(j) + 1
            }
        }
        dp.last
    }
}
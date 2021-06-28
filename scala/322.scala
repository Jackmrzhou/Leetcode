object Solution {
    def coinChange(coins: Array[Int], amount: Int): Int = {
        if (amount == 0) return 0
        val dp = Array.fill(amount+1)(0)
        dp(0) = 0
        for (i <- 1 to amount; coin <- coins) {
            if (coin < i) {
                if (dp(i) == 0 && dp(i-coin) != 0) dp(i) = dp(i-coin) + 1
                else if (dp(i-coin) != 0) dp(i) = dp(i).min(dp(i-coin) + 1)
            } else if (i == coin) dp(i) = 1
        }
        if (dp.last == 0) -1 else dp.last
    }
}
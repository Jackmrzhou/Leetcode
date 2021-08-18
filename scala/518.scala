object Solution {
    def change(amount: Int, coins: Array[Int]): Int = {
        val dp = Array.fill(amount+1)(0)
        dp(0) = 1
        val sorted = coins.sorted
        for (coin <- sorted; if coin <= amount) {
            for (j <- coin to amount) {
                dp(j) += dp(j-coin)
            }
        }
        dp.last
    }
}
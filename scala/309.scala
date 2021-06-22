object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        var cooldown = 0
        var buy = 0 - prices.head
        var sell = 0
        for (i <- 1 until prices.length) {
            val preCooldown = cooldown
            val preBuy = buy
            cooldown = cooldown.max(sell)
            buy = buy.max(preCooldown - prices(i))
            sell = preBuy + prices(i)
        } 
        sell.max(cooldown)
    }
}
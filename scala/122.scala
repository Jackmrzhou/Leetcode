object Solution {
    def maxProfit(prices: Array[Int]): Int = {
      val res = prices.zipWithIndex.foldLeft((prices(0), 0)){
        case ((yDay, profit), (price, x)) => {
          (price, profit.max(price - yDay + profit))
        }
      }
      res._2
    }
}

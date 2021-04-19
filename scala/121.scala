object Solution {
    def maxProfit(prices: Array[Int]): Int = {
      val res = prices.zipWithIndex.foldLeft((100001, 0)){
        case ((min, profit), (price, x)) => {
          (price.min(min), profit.max(price - min))
        }
      }
      res._2
    }
}

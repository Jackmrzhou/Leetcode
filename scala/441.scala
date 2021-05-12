object Solution {
    def arrangeCoins(n: Int): Int = {
      val total = (_n:Long) => (1+_n)*_n/2
      for (i <- 1 to n) {
        if (total(i) == n) return i
        else if (total(i) > n) return i - 1
      }
      return 0
    }
}

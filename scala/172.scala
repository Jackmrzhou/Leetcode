object Solution {
    def trailingZeroes(n: Int): Int = {
      if (n == 0) return 0
      return n / 5 + trailingZeroes(n/5)
    }
}

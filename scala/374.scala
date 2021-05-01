class Solution extends GuessGame {
    def guessNumber(n: Int): Int = {
        def find(l: Int, r: Int): Int = {
          if (l >= r) return l
          val mid = l + (r-l) / 2
          val guessRes = guess(mid)
          if (guessRes == 0) return mid
          if (guessRes == -1) return find(l, mid)
          return find(mid+1, r)
        }
        find(1, n)
    }
}

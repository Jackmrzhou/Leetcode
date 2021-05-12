object Solution {
    def longestPalindrome(s: String): Int = {
      val chCount = s.foldLeft(Map[Char, Int]()) {
        case (m, ch) => {
          if (m.contains(ch)) {
            m + (ch -> (m(ch)+1))
          } else {
            m + (ch -> 1)
          }
        }
      }
      val res = chCount.foldLeft(0){
        case (n, (k,v)) => {
          n + (v - v%2)
        }
      }
      if (chCount.exists(e => e._2 % 2 == 1)) res + 1
      else res
    }
}

object Solution {
    def longestPalindrome(s: String): String = {
      def search(pos: Int): (Int, Int) = {
        var l = pos - 1
        var r = pos + 1
        var maxLen = 1
        var res = (pos, pos)
        while (l >= 0 && r < s.length() && s(l) == s(r)){
          if (r-l+1 > maxLen) {
            maxLen = r-l+1
            res = (l, r)
          }
          l -= 1
          r += 1
        }
        l = pos
        r = pos + 1
        while (l>=0 && r < s.length() && s(l) == s(r)) {
          if (r-l+1 > maxLen) {
            maxLen = r-l+1
            res = (l, r)
          }
          l-=1
          r+=1
        }
        res
      }
      var res = ""
      var maxLen = 0
      for ( i <- 0 until s.length()) {
        val range = search(i)
        if (range._2 - range._1 + 1 > maxLen) {
          res = s.substring(range._1, range._2+1)
          maxLen = range._2 - range._1 + 1
        }
      }
      res
    }
}

object Solution {
    def convert(s: String, numRows: Int): String = {
      if (numRows == 1) return s
      val step = 2*numRows - 2
      val res = new StringBuilder()
      for ( i <- 0 until numRows ) {
        if (i == 0 || i == numRows-1) {
          for (j <- i until s.length() by step)
            res += s(j)
        } else {
          var j = i
          while (j < s.length()) {
            res += s(j)
            j += (numRows-1-i) * 2
            if (j < s.length())
              res += s(j)
            j += i*2
          }
        }
      }
      res.mkString
    }
}

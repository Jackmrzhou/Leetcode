object Solution {
    def convertToTitle(columnNumber: Int): String = {
      val sb = new StringBuilder()
      var n = columnNumber
      while(n > 0) {
        val m = ('A'.toInt-1 + n % 26).toChar
        if (m.toInt == 'A'.toInt - 1) {
            sb += 'Z'
        } else {
            sb += m
        }
        n = (n-1) / 26
      }
      sb.reverse.mkString
    }
}

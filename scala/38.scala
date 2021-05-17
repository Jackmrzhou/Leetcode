object Solution {
    def countAndSay(n: Int): String = {
      val s = "1"
      if (n == 1) return s
      val res =  (1 until n).foldLeft(s) {
        case (str, _) => {
          val sb = new StringBuilder()
          (str + 'e').zipWithIndex.foldLeft(0) {
            case (last, (ch, i)) => {
              if (ch != str(last)) {
                sb += ('1'.toInt + (i-1-last)).toChar
                sb += str(last)
                i
              } else {
                last
              }
            }
          }
          sb.toString()
        }
      }
      res
    }
}

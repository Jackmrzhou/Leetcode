object Solution {
    def myAtoi(s: String): Int = {
      var l = 0
      while ( l < s.length && s(l) == ' ') l += 1
      if (l >= s.length) return 0
      val _s = s.substring(l)
      val Si = 0 // initial
      val S1 = 1 // sign
      val S2 = 2 // digit
      val S3 = 3 // error
      val S4 = 4 // end
      val res = _s.foldLeft((Si, "")) {
        case ((state, token), ch) => state match {
          case Si => {
            if (ch == '-' || ch == '+') (S1, token + ch)
            else if (ch.isDigit){
              if (ch != '0') (S2, token + ch)
              else (S1, token)
            }
            else (S3, "")
          }
          case S1 => {
            if (ch.isDigit) {
              if (ch == '0') (S2, token)
              else (S2, token + ch)
            } else {
              (S3, "")
            }
          }
          case S2 => {
            if (ch.isDigit) {
              if (ch == '0' && (token == "" || token == "+" || token == "-")) (S2, token)
              else (S2, token + ch)
            } else {
              (S4, token)
            }
          }
          case S3 => (S3, "")
          case S4 => (S4, token)
        }
      }
      if (res._1 == S3 || res._2 == "") return 0
      val sign = if (res._2.head == '-' || res._2.head == '+') res._2.head else '+'
      val numStr = if (res._2.head == '-' || res._2.head == '+') res._2.substring(1) else res._2
      var num : Long=0
      if (numStr.length() > 10) { if (sign == '+') num = Int.MaxValue else num = Int.MinValue }
      else if (numStr.length() == 0) num = 0
      else num = numStr.toLong
      if (sign == '+' && num > Int.MaxValue ) Int.MaxValue
      else if (sign == '-' && -num < Int.MinValue ) Int.MinValue
      else if (sign == '+') num.toInt else -num.toInt
    }
}

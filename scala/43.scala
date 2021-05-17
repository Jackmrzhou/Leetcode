object Solution {
    def multiply(num1: String, num2: String): String = {
      if (num1 == "0" || num2 == "0") return "0"
      val tmp = Array.fill(401)(0)
      var last = 0
      for (i <- 0 until num1.length()){
        var carry = 0
        for (j <- 0 until num2.length()) {
          val v = num1(num1.length - 1 - i).asDigit * num2(num2.length - 1 - j).asDigit + carry + tmp(i+j)
          tmp(i+j) = v % 10
          carry = v / 10
          last = i+j
        }
        if (carry != 0) {
          tmp(i+num2.length()) = carry
          last = i + num2.length()
        }
      }
      tmp.slice(0, last+1).map(d => ('0'.toInt + d).toChar).reverse.mkString
    }
}

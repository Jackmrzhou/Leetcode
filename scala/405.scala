object Solution {
    def toHex(num: Int): String = {
      if (num == 0) return "0"
      var n = num
      var res = ""
      val map = "0123456789abcdef"
      while (n != 0) {
        val last = n & 0xf
        n = (n >>> 4)
        res += map(last)
      }
      res.reverse
    }
}

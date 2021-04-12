object Solution {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) return false
    var res = 0
    val isNeg = x < 0
    var input = x
    while (input != 0){
      val last = input % 10
      input = input / 10
      if (res.abs > 214748364 || ( res.abs == 214748364 && last > 7))
        return false
      res = res * 10 + last
    }
    res == x
  }
}

println(Solution.isPalindrome(12321))

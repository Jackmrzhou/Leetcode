object Solution {
  def isHappy(n: Int): Boolean = {
    def happy(n:Int, s:Set[Int]): Boolean = {
      if (n == 1) return true
      if (s(n)) return false
      val newN = n.toString().foldLeft(0){
        case (sum, ch) => sum + ch.asDigit * ch.asDigit
      }
      happy(newN, s + n)
    }
    happy(n, Set())
  }
}

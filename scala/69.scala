object Solution {
  def mySqrt(x: Int): Int = {
    var l = 1
    var r = x
    if (x == 0) return 0
    while (l < r) {
      val mid = (l+r) / 2
      if (x / mid < mid) r = mid
      else l = mid + 1
    }
    if (x/l < l) l-1
    else l
  }
}

println(Solution.mySqrt(5))

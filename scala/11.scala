object Solution {
    def maxArea(height: Array[Int]): Int = {
      var l = 0
      var r = height.length - 1
      var res = 0
      while (l < r) {
        val area = height(l).min(height(r)) * (r-l)
        res = res.max(area)
        if (height(l) > height(r)) r -= 1
        else l += 1
      }
      res
    }
}

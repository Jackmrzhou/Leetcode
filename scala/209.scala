object Solution {
    def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
      var l = 0
      var r = 0
      var sum = 0
      var res = 0
      while( r < nums.length ) {
        sum += nums(r)
        while (sum - nums(l) >= target && l < r) {
          sum -= nums(l)
          l += 1
        }
        r += 1
        if (sum >= target && (res == 0 || (r-l) < res)) res = r-l
      }
      res
    }
}

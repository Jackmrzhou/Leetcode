object Solution {
    def jump(nums: Array[Int]): Int = {
      val res = Array.fill(nums.length)(0)
      for ( i <- nums.length - 1 to 0 by -1) {
        for (j <- 1 to nums(i); if i+j < nums.length) {
          res(i) = if ( res(i+j) != -1 && (res(i) == 0 || res(i) > 1 + res(i+j))) 1+res(i+j) else res(i)
        }
        if (res(i) == 0 && i != nums.length-1) res(i) = -1
      }
      res(0)
    }
}

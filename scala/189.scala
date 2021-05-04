object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
      val _k = k % nums.length
      if (_k == 0) return
      val res = nums.slice(nums.length- _k, nums.length) ++ nums.slice(0, nums.length - _k)
      for (i <- 0 until nums.length)
        nums(i) = res(i)
    }
}

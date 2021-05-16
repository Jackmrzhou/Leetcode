object Solution {
    def search(nums: Array[Int], target: Int): Int = {
      def s(i: Int, j: Int): Int = {
        if (i >= j) return if (nums(i) == target) i else -1
        val mid = i + (j-i) / 2
        if (nums(i) > nums(j)) {
          val l = s(i, mid)
          if (l != -1) return l
          val r = s(mid+1, j)
          if (r != -1) return r
          return -1
        } else {
          if (nums(i) > target || nums(j) < target) return -1
          if (nums(mid) >= target) return s(i, mid)
          else return s(mid+1, j)
        }
      }
      s(0, nums.length-1)
    }
}

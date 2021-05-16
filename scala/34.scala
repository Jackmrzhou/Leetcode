import scala.annotation.tailrec
object Solution {
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
      @tailrec
      def first(i: Int, j: Int): Int = {
        if (i >= j) return if (nums(i) == target) i else -1
        val mid = i + (j-i)/2
        if (nums(mid) >= target) return first(i, mid)
        else return first(mid+1, j)
      }
      @tailrec
      def last(i: Int, j: Int): Int = {
        if (i >= j) return if (nums(i) == target) i else -1
        val mid = i + (j-i)/2+1
        if (nums(mid) <= target) return last(mid, j)
        else return last(i, mid-1)
      }
      if (nums.length == 0) return Array(-1, -1)
      val l = first(0, nums.length - 1)
      if (l == -1) return Array(-1,-1)
      Array(l, last(0, nums.length - 1))
    }
}

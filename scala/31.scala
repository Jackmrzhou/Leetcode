import java.util.Arrays
object Solution {
    def nextPermutation(nums: Array[Int]): Unit = {
      if (nums.length == 1) return
      def swap(i: Int, j: Int) {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
      }
      var x = 0
      var y = 0
      for (i <- 0 until nums.length)
        for (j <- i until nums.length)
          if (nums(i) < nums(j)) {
            x = i
            y = j
          }
      swap(x, y)
      if (x != y)
        Arrays.sort(nums, x+1, nums.length)
      else
        Arrays.sort(nums)
    }
}

object Solution {
    def moveZeroes(nums: Array[Int]): Unit = {
      def swap(i: Int, j: Int): Unit = {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
      }
      var i=0
      var j=0
      while(j < nums.length) {
        if (nums(j) != 0) {
          swap(i, j)
          i += 1
        }
        j += 1
      }
    }
}

object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0
    var index = 0
    for (num <- nums) {
      if (num != nums(index)) {
        index += 1
        nums(index) = num
      }
    }
    index+1
  }
}

println(Solution.removeDuplicates(Array(1,2,2,3,4,5)))

object Solution {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    if (nums.length == 0) return 0
    var index = 0
    for (num <- nums){
      if (num != `val`) {
        nums(index) = num
        index += 1
      }
    }
    index
  }
}

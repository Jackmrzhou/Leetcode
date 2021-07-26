object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    nums.indexWhere(_ >= target) match {
      case -1 => nums.length
      case value => value
    }
  }
}

println(Solution.searchInsert(Array(1,2,3,5), 4))
println(Solution.searchInsert(Array(1,3,4,5), 0))
println(Solution.searchInsert(Array(1,2,3,3,4), 3))

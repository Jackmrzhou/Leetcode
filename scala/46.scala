object Solution {
    def permute(nums: Array[Int]): List[List[Int]] = {
      nums.permutations.map(arr=>arr.toList).toList
    }
}

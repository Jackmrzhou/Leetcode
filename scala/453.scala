object Solution {
    def minMoves(nums: Array[Int]): Int = {
        val min = nums.min
        nums.foldLeft(0){
            case (res, n) => res + n-min
        }
    }
}
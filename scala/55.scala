object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        (0 until nums.length).foldLeft(0) {
            case (right, i) => {
                if (right >= nums.length - 1 || nums(i) == 0 || i > right) right
                else math.max(right, nums(i) + i)
            }
        } >= nums.length - 1
    }
}
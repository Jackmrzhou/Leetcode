object Solution {
    def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
        var length = 0
        var count = 0
        for (n <- nums) {
            n match {
                case 0 => {
                    count = 0
                }
                case 1 => {
                    count += 1
                    length = length.max(count)
                }
            }
        }
        length
    }
}
object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        nums.foldLeft((0, 0)) {
            case ((a, b), n) => {
              val newA = (a^n) & ~b
              (newA, (b^n) & ~newA)
            }
        }._1
    }
}
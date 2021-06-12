object Solution {
    def singleNumber(nums: Array[Int]): Array[Int] = {
        val xorRes = nums.foldLeft(0) {
            case (r, n) => r ^ n
        }
        var mask = 1
        while ((mask & xorRes) == 0) {
            mask <<= 1
        }
        val res = nums.foldLeft((xorRes, xorRes)) {
            case ((a,b), n) => {
                if ((n&mask) != 0) (a^n, b)
                else (a, b^n)
            }
        }
        Array(res._1, res._2)
    }
}
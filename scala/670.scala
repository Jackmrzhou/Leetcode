object Solution {
    def maximumSwap(num: Int): Int = {
        val digits = num.toString().toCharArray().map(p => p -'0')
        var max = num
        def swap(i: Int, j: Int) {
            val tmp = digits(i)
            digits(i) = digits(j)
            digits(j) = tmp
        }
        for (i <- 0 until digits.length; j <- 0 until i) {
            swap(i, j)
            max = max.max(digits.mkString.toInt)
            swap(i, j)
        }
        max
    }
}
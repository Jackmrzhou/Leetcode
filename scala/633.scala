object Solution {
    def judgeSquareSum(c: Int): Boolean = {
        var a: Long = 0
        while (a*a <= c) {
            val b = math.sqrt(c-a*a)
            if (b.toInt*b.toInt+a*a == c)
                return true
            a += 1
        }
        false
    }
}
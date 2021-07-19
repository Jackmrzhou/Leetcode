object Solution {
    def findNthDigit(n: Int): Int = {
        def f(n: Int, digits: Int): Int = {
            val base = math.pow(10, digits-1).toLong
            val total = 9 * base * digits
            if (n < total) {
                val num = base + n / digits
                num.toString()(n % digits) - '0'
            } else {
                f(n - total.toInt, digits + 1)
            }
        }
        f(n-1, 1)
    }
}
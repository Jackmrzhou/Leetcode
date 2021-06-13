object Solution {
    def findComplement(num: Int): Int = {
        var mask: Long = 1
        for (i <- 0 to 31) {
            if (((1<<i) & num) != 0) mask = (1<<i)
        }
        ((mask << 1) - 1 - num.toLong).toInt
    }
}
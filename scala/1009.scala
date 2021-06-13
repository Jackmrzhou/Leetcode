object Solution {
    def bitwiseComplement(n: Int): Int = {
        var mask: Long = 1
        for (i <- 0 to 31) {
            if (((1<<i) & n) != 0) mask = (1<<i)
        }
        ((mask << 1) - 1 - n.toLong).toInt
    }
}
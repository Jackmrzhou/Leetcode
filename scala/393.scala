object Solution {
    def validUtf8(data: Array[Int]): Boolean = {
        var i = 0
        def getN(x: Int): Int = {
            if ((x & 128) == 0) 1
            else if ((x & 224) == 192) 2
            else if ((x& 240) == 224) 3
            else if ((x& 248) == 240) 4
            else -1
        }
        while (i < data.length) {
            val n = getN(data(i))
            if (n == -1) return false
            else {
                for (j <- 0 until n - 1) {
                    i += 1
                    if (i >= data.length || (data(i) & 192) != 128) return false
                }
            }
            i += 1
        }
        true
    }
}
object Solution {
    def maxProduct(words: Array[String]): Int = {
        val bitMap = Array.fill(words.length)(0)
        for (i <- 0 until words.length){
            val b = words(i).foldLeft(0){
                case (bits, ch) => bits | (1 << (ch - 'a'))
            }
            bitMap(i) = b
        }
        var res = 0
        for (i <- 0 until words.length; j <- 0 until words.length) {
            if ((bitMap(i) & bitMap(j)) == 0) {
                res = res.max(words(i).length() * words(j).length())
            }
        }
        res
    }
}
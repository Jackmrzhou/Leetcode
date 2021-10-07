object Solution {
    def isOneBitCharacter(bits: Array[Int]): Boolean = {
        val n = bits.length
        if (n <= 2) {
            bits(0) == 0
        } else {
            isOneBitCharacter(bits.slice(bits(0)+1, n))
        }
    }
}
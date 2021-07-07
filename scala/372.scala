object Solution {
    def superPow(a: Int, b: Array[Int]): Int = {
        def s(a: Long, b: BigInt): Int = {
            if ( b == 0) 1
            else if ((b & 1) == 1) ((a * s(a, b - 1)) % 1337).toInt
            else {
                val tmp = s(a, b>>1)
                (tmp*tmp % 1337).toInt
            }
        }
        s(a.toLong, BigInt(b.mkString))
    }
}
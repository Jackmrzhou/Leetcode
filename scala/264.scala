import scala.collection.mutable.ArrayBuffer
object Solution {
    def nthUglyNumber(n: Int): Int = {
        val res = ArrayBuffer[Int]()
        var fac2 = 2
        var i2 = 0
        var fac3 = 3
        var i3 = 0
        var fac5 = 5
        var i5 = 0
        res += 1
        for (i <- 1 until n) {
            val newUg = fac5 min fac3 min fac2
            res += newUg
            if (newUg == fac2) {
                i2 += 1
                fac2 = res(i2) * 2
            }
            if (newUg == fac3) {
                i3 += 1
                fac3 = res(i3) * 3
            }
            if (newUg == fac5) {
                i5 += 1
                fac5 = res(i5) * 5
            }
        }
        res.toArray.last
    }
}
import scala.collection.mutable
object Solution {
    def fractionToDecimal(numerator: Int, denominator: Int): String = {
        var n = numerator.toLong.abs
        val d = denominator.toLong.abs
        val res = new StringBuilder()
        if (n > d) {
            res.append((n/d).toString())
            n = n % d
        } else {
            res += '0'
        }
        val map = mutable.Map[Long, Int]()
        map.put(n, res.length)
        if (n != 0) res += '.'
        while (n != 0) {
            n *= 10
            val x = n / d
            n = n % d
            res.append(x.toString)
            if (map.contains(n)) {
                res += ')'
                res.insert(map(n)+1, '(')
                n = 0
            } else {
                map.put(n, res.length-1)
            }
        }
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) "-" + res.toString()
        else res.toString()
    }
}
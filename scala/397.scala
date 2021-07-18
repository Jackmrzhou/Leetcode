import scala.collection.mutable.Map
object Solution {
    def integerReplacement(n: Int): Int = {
        val mem = Map[Int, Int]()
        def r(n: Int): Int = {
            if (n == 1)  0
            else if (mem.contains(n)) mem(n)
            else { 
                val res = if (n % 2 == 1) if (n == Int.MaxValue) 2 + r(((n.toLong+1)/2).toInt) else  1 + r(n+1).min(r(n-1))
                else 1 + r(n/2)
                mem += (n -> res)
                res
            }
        }
        r(n)
    }
}
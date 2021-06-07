import scala.collection.mutable.ListBuffer
object Solution {
    def combinationSum3(k: Int, n: Int): List[List[Int]] = {
        val res = ListBuffer[List[Int]]()
        def find(k: Int, n: Int, comb: List[Int]) {
            if (k == 1) {
                if (n > comb.last && n < 10) res += comb :+ n
            } else {
                val last = if (comb.isEmpty) 0 else comb.last
                for (i <- last + 1 to 9.min(n / 2)) {
                    find(k-1, n-i, comb :+ i)
                }
            }
        }
        find(k, n, Nil)
        res.toList
    }
}
import scala.collection.mutable.ListBuffer
object Solution {
    def lexicalOrder(n: Int): List[Int] = {
        var cur = 1
        val res = ListBuffer[Int]()
        while (res.length < n) {
            res += cur
            if (cur * 10 <= n) {
                cur *= 10
            } else {
                if (cur >= n) {
                    cur /= 10
                }
                cur += 1
                while (cur % 10 == 0) cur /= 10
            }
        }
        res.toList
    }
}
import scala.collection.mutable
import scala.util.Random
class Solution(_m: Int, _n: Int) {

    val m = mutable.Map[Int, Int]()
    var total = _m * _n

    def flip(): Array[Int] = {
        val n = Random.nextInt(total)
        val res = m.getOrElse(n, n)
        total -= 1
        m += (n -> m.getOrElse(total, total))
        Array(res/_n, res%_n)
    }

    def reset() {
        m.clear()
        total = _m*_n
    }

}
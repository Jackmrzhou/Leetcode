import scala.annotation.meta.param
object Solution {
    def findLongestChain(pairs: Array[Array[Int]]): Int = {
        val sorted = pairs.sortBy(_.head)
        var res = Array.fill(pairs.length)(1)
        for (i <- sorted.length-1 to 0 by -1; j <- i+1 until sorted.length){
            if (sorted(i).last < sorted(j).head) res(i) = res(i).max(res(j)+1)
        }
        res.max
    }
}
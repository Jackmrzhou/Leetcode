import scala.collection.mutable
object Solution {
    def findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int = {
        if (maxMove == 0) return 0
        val M = 1000000000 + 7
        val map = Array.fill(maxMove+1, m, n)(0)
        map(0)(startRow)(startColumn) = 1
        var res = 0
        for (k <- 0 until maxMove; i <- 0 until m; j <- 0 until n)  {
            if (i == 0) res = (res + map(k)(i)(j)) % M
            else map(k+1)(i)(j) += map(k)(i-1)(j)
            map(k+1)(i)(j) %= M
            if (j == 0) res = (res + map(k)(i)(j)) % M
            else map(k+1)(i)(j) += map(k)(i)(j-1)
            map(k+1)(i)(j) %= M
            if (i == m-1) res = (res + map(k)(i)(j)) % M
            else map(k+1)(i)(j) += map(k)(i+1)(j)
            map(k+1)(i)(j) %= M
            if (j == n-1) res = (res + map(k)(i)(j)) % M
            else map(k+1)(i)(j) += map(k)(i)(j+1)
            map(k+1)(i)(j) %= M
        }
        res
    }
}
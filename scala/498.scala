import scala.collection.mutable.ArrayBuffer
object Solution {
    def findDiagonalOrder(mat: Array[Array[Int]]): Array[Int] = {
        val n = mat.length
        val m = mat.head.length
        def getY(x: Int, k: Int): Int = {
            // -y+n = x+k
            n-1-x-k
        }
        var dir = true
        var x = 0
        var k = n-1
        val res = Array.ofDim[Int](m*n)
        var counter = 0
        while (k > -m) {
            var y = getY(x, k)
            if (dir) {
                while (y >= 0 && x < m && y < n) {
                    res(counter) = mat(y)(x)
                    counter += 1
                    x += 1
                    y = getY(x, k)
                }
            } else {
                while (x >= 0 && y < n) {
                    res(counter) = mat(y)(x)
                    counter += 1
                    x -= 1
                    y = getY(x, k)
                }
            }
            if (k <= 0 && !dir) x += 2
            if (x < 0) x = 0
            else if (x >= m) x = m-1
            dir = !dir
            k -= 1
        }
        res
    }
}
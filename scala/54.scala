import scala.collection.mutable.ListBuffer
object Solution {
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        val buf = ListBuffer[Int]()
        if (matrix.length == 0 || matrix.head.length == 0) return Nil
        buf ++= matrix.head
        if (matrix.length > 1) {
            buf ++= matrix.slice(1, matrix.length-1).map(l => l.last)
            buf ++= matrix.last.reverse
            if (matrix.head.length > 1) {
                buf ++= matrix.slice(1, matrix.length-1).map(l => l.head).reverse
            }
        }
        buf.toList ::: spiralOrder(matrix.slice(1, matrix.length-1).map(l => l.slice(1, l.length-1)))
    }
}
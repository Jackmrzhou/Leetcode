import scala.annotation.tailrec
object Solution {
    def generateMatrix(n: Int): Array[Array[Int]] = {
        @tailrec
        def gen(start: Int, i: Int, d: Int, matrix: Array[Array[Int]]) {
            d match {
                case 0 => ()
                case 1 => matrix(i)(i) = start
                case _ => {
                    var counter = start
                    for (j <- i until i+d-1) {
                        matrix(i)(j) = counter
                        counter += 1
                    }
                    for (j <- i until i+d-1) {
                        matrix(j)(i+d-1) = counter
                        counter += 1
                    }
                    for (j <- i+d-1 until i by -1) {
                        matrix(i+d-1)(j) = counter
                        counter += 1
                    }
                    for (j <- i+d-1 until i by -1) {
                        matrix(j)(i) = counter
                        counter += 1
                    }
                    gen(counter, i+1, d-2, matrix)
                }
            }
        }
        val matrix = Array.ofDim[Int](n, n)
        gen(1, 0, n, matrix)
        matrix
    }
}
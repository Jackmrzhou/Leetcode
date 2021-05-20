object Solution {
    def rotate(matrix: Array[Array[Int]]): Unit = {
        for (i <- 0 until matrix.length / 2) {
            for (j <- matrix.length - i - 1 until i by -1) {
                val tmp = matrix(i)(j)
                matrix(i)(j) = matrix(matrix.length - j - 1)(i)
                matrix(matrix.length - j - 1)(i) = matrix(matrix.length - i - 1)(matrix.length - j - 1)
                matrix(matrix.length - i - 1)(matrix.length - j - 1) = matrix(j)(matrix.length - i -1)
                matrix(j)(matrix.length - i -1) = tmp
            }
        }
    }
}
class NumMatrix(_matrix: Array[Array[Int]]) {

    val dp = {
        val arr = Array.fill(_matrix.length+1, _matrix.head.length+1)(0)
        arr(1)(1) = _matrix.head.head
        for (i <- 1 until _matrix.length) {
            arr(i+1)(1) = arr(i)(1) + _matrix(i)(0)
        }
        for (j <- 1 until _matrix.head.length) {
            arr(1)(j+1) = arr(1)(j) + _matrix(0)(j)
        }
        for (i <- 1 until _matrix.length; j <- 1 until _matrix.head.length) {
            arr(i+1)(j+1) = arr(i)(j+1) + arr(i+1)(j) - arr(i)(j) + _matrix(i)(j)
        }
        arr
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
        dp(row2+1)(col2+1) + dp(row1)(col1) - dp(row1)(col2+1) - dp(row2+1)(col1)
    }

}
object Solution {
    def minPathSum(grid: Array[Array[Int]]): Int = {
        for (i <- 0 until grid.length; j <- 0 until grid.head.length) {
            (i, j) match {
                case (0, 0) => ()
                case (0, _) => grid(0)(j) = grid(0)(j-1) + grid(0)(j)
                case (_, 0) => grid(i)(0) = grid(i-1)(0) + grid(i)(0)
                case (_, _) => grid(i)(j) = math.min(grid(i-1)(j), grid(i)(j-1)) + grid(i)(j)
            }
        }
        grid.last.last
    }
}
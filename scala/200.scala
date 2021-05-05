object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
      val n = grid.length
      val m = grid.head.length
      def dfs(i: Int, j: Int): Unit = {
        if (i < 0 || i >= n || j < 0 || j >= m) return
        if (grid(i)(j) != '1') return
        grid(i)(j) = '2'
        dfs(i+1, j)
        dfs(i-1, j)
        dfs(i, j+1)
        dfs(i, j-1)
      }
      var counter = 0
      for (i <- 0 until n; j <- 0 until m) {
        if (grid(i)(j) == '1') {
          counter += 1
          dfs(i, j)
        }
      }
      counter
    }
}

object Solution {
    def solve(board: Array[Array[Char]]): Unit = {
        def dfs(i: Int, j: Int, set: Boolean): Boolean = {
            if (i < 0 || i >= board.length || j < 0 || j >= board.head.length) false
            else if (set) { 
              if (board(i)(j) == 'v'){
                    board(i)(j) = '-'
                    dfs(i-1, j, true)
                    dfs(i+1, j, true)
                    dfs(i, j+1, true)
                    dfs(i, j-1, true)
              }
              false 
            }
            else if (board(i)(j) == 'X' || board(i)(j) == 'v') true
            else if (board(i)(j) == 'O') {
                board(i)(j) = 'v'
                val a = dfs(i-1,j, false)
                val b = dfs(i,j-1, false)
                val c = dfs(i+1,j, false)
                val d = dfs(i,j+1, false)
                if (a && b && c && d) {
                    true
                } else {
                    board(i)(j) = '-'
                    dfs(i-1, j, true)
                    dfs(i+1, j, true)
                    dfs(i, j+1, true)
                    dfs(i, j-1, true)
                    false
                }
            } else {
                false
            }
        }
        for (i <- 0 until board.length; j <- 0 until board.head.length) {
            if (board(i)(j) == 'O')
              dfs(i, j, false)
        }
        for (i <- 0 until board.length; j <- 0 until board.head.length) {
            if (board(i)(j) == '-' ) board(i)(j) = 'O'
            else if (board(i)(j) == 'v') board(i)(j) = 'X'
        }
    }
}
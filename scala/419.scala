object Solution {
    def countBattleships(board: Array[Array[Char]]): Int = {
        val dir = Array((0, 1), (1, 0), (-1, 0), (0, -1))
        def dfs(i: Int, j: Int) {
            if (i < 0 || i >= board.length || j < 0 || j >= board.head.length) return
            if (board(i)(j) == 'X') {
                board(i)(j) = '_'
                for (d <- dir) {
                    dfs(i+d._1, j+d._2)
                }
            }
        }
        var res = 0
        for (i <- 0 until board.length; j <- 0 until board.head.length) {
            if (board(i)(j) == 'X') {
                res += 1
                dfs(i, j)
            }
        }
        res
    }
}
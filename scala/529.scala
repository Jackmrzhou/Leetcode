object Solution {
    def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
        if (board(click.head)(click.last) == 'M') {
            board(click.head)(click.last) = 'X'
            board
        } else {
            val dirs = Array((0,1), (0, -1), (1, 0), (-1, 0), (1,1), (1, -1), (-1, 1), (-1, -1))
            def valid(i: Int, j: Int): Boolean = !(i < 0 || i >= board.length || j < 0 || j >= board.head.length)
            def dfs(i: Int, j: Int) {
                if (valid(i, j)){
                    if (board(i)(j) != 'B' && !board(i)(j).isDigit) {
                        val mines = dirs.map(p => (i+p._1, j+p._2)).count(p => valid(p._1, p._2) && board(p._1)(p._2) == 'M')
                        if (mines > 0) {
                            board(i)(j) =('0'+mines).toChar
                        } else {
                            board(i)(j) = 'B'
                            dirs.foreach(p => dfs(i+p._1, j+p._2))
                        }
                    }
                }
            }
            dfs(click.head, click.last)
            board
        }
    }
}
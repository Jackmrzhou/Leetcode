object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        def search(i: Int, j: Int, k: Int): Boolean = {
            if (k >= word.length()) return true
            (i, j) match {
                case (i,j) if i==board.length || j == board.head.length || i == -1 || j == -1 => false   
                case _ => {
                    if (board(i)(j) != word(k)) false
                    else {
                        val tmp = board(i)(j)
                        board(i)(j) = '0'
                        val res = search(i-1, j, k+1) || search(i+1, j, k+1) || search(i, j-1, k+1) || search(i, j+1, k+1)
                        board(i)(j) = tmp
                        return res
                    }
                }
            }
        }       
        for (i <- 0 until board.length; j <- 0 until board.head.length)
            if (search(i, j, 0)) return true
        false
    }
}
object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
      for (row <- board) {
        val map = Array.fill(10)(0)
        for (cell <- row; if cell.isDigit) {
          if (map(cell.asDigit) != 0) {
            return false
          } else {
            map(cell.asDigit) = 1
          }
        }
      }
      for (i <- 0 until board.length) {
        val map = Array.fill(10)(0)
        for (j <- 0 until board.length) {
          val d = board(j)(i)
          if (d.isDigit) {
            if (map(d.asDigit) != 0)
              return false
            else
              map(d.asDigit) = 1
          }
        }
      }
      def test(i: Int, j: Int): Boolean = {
        val map = Array.fill(10)(0)
        for (x <- i until i+3)
          for (y <- j until j+3){
            val d = board(x)(y)
            if (d.isDigit) {
            if (map(d.asDigit) != 0)
              return false
            else
              map(d.asDigit) = 1
            }
          }
        true
      }
      for (i <- 0 until board.length by 3)
        for (j <- 0 until board.length by 3)
          if (!test(i,j)) return false
      true
    }
}

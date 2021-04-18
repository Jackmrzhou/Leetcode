object Solution {
    def getRow(rowIndex: Int): List[Int] = {
         rowIndex match {
          case 0 => List(1)
          case _ => {
            val last = 0 +: getRow(rowIndex - 1) :+ 0

            val newLast = for (i <- 1 until last.length) yield last(i)+last(i-1)
            newLast.toList
          }
        }
    }
}

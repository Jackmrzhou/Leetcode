object Solution {
    def generate(numRows: Int): List[List[Int]] = {
        numRows match {
          case 1 => List(List(1))
          case _ => {
            val prev = generate(numRows - 1)
            val last = 0 +: prev.last :+ 0

            val newLast = for (i <- 1 until last.length) yield last(i)+last(i-1)
            prev :+ newLast.toList
          }
        }
    }
}

println(Solution.generate(3))

object Solution {
    def findRelativeRanks(score: Array[Int]): Array[String] = {
        val sorted = score.zipWithIndex.sortBy(_._1).reverse
        val res = Array.ofDim[String](score.length)
        for (i <- 0 until sorted.length) {
            i match {
                case 0 => res(sorted(i)._2) = "Gold Medal"
                case 1 => res(sorted(i)._2) = "Silver Medal"
                case 2 => res(sorted(i)._2) = "Bronze Medal"
                case _ => res(sorted(i)._2) = s"${i+1}"
            }
        }
        res
    }
}
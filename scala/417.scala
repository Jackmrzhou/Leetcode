import scala.collection.mutable.ListBuffer
object Solution {
    def pacificAtlantic(heights: Array[Array[Int]]): List[List[Int]] = {
        val canReachP = Array.fill(heights.length, heights.head.length)(false)
        val canReachA = Array.fill(heights.length, heights.head.length)(false)
        val dir = Array((0, 1), (1, 0), (-1, 0), (0, -1))
        def dfs(i: Int, j: Int, canReach: Array[Array[Boolean]]) {
            if (!canReach(i)(j)) {
                canReach(i)(j) = true
                for (d <- dir) {
                    val ii = i + d._1
                    val jj = j + d._2
                    if (ii >= 0 && ii < canReach.length && jj >= 0 && jj < canReach.head.length && heights(i)(j) <= heights(ii)(jj)) dfs(ii, jj, canReach)
                }
            }
        } 
        for (i <- 0 until heights.length) {
            dfs(i, 0, canReachP)
            dfs(i, heights.head.length-1, canReachA)
        }
        for (j <- 0 until heights.head.length) {
            dfs(0, j, canReachP)
            dfs(heights.length-1, j, canReachA)
        }
        val res = ListBuffer[List[Int]]()
        for (i <- 0 until heights.length; j <- 0 until heights.head.length) {
            if (canReachA(i)(j) && canReachP(i)(j)) res += List(i, j)
        }
        res.toList
    }
}
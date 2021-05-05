import scala.collection.mutable.ListBuffer
object Solution {
    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
      val graph = Array.fill(numCourses)(ListBuffer[Int]())
      for (e <- prerequisites)
        graph(e.head) += e.last
      def test(i: Int, visited: Set[Int]): Boolean = {
        if (visited.contains(i)) return true
        var res = false
        for (_i <- 0 until graph(i).length) {
          val n = graph(i).head
          graph(i).remove(0)
          res = res || test(n, visited + i)
        }
        res
      }
        !(0 until graph.length).foldLeft(false) {
          case (res, n) => res || test(n, Set[Int]())
        }
    }
}

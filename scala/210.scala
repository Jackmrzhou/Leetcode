import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
object Solution {
    def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
      val g = Array.fill(numCourses)(List[Int]())
      val in = Array.fill(numCourses)(0)
      for (p <- prerequisites) {
        g(p(1)) = g(p(1)) :+ p(0)
        in(p(0)) += 1
      }
      val q = Queue[Int]()
      in.zipWithIndex.foreach(e => {
        if (e._1 == 0) q.enqueue(e._2)
      })
      val res = ListBuffer[Int]()
      while (!q.isEmpty) {
        val n = q.dequeue()
        res += n
        for (_n <- g(n)) {
          in(_n) -= 1
          if (in(_n) == 0)
            q.enqueue(_n)
        }
      }
      if (res.length == numCourses) res.toArray
      else Array[Int]()
    }
}

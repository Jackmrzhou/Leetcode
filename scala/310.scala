import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
import scala.collection.mutable.TreeSet
object Solution {
    def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
        val g = Array.fill(n)(TreeSet[Int]())
        for (e <- edges) {
            g(e(0)) += e(1)
            g(e(1)) += e(0)
        }
        val q = Queue[Int]()
        for (i <- 0 until g.length) {
            if (g(i).size == 1) {
                q.enqueue(i)
            }
        }
        if (q.isEmpty) return List(n-1)
        var left = n
        while (left >= 3) {
            (1 to q.length).foreach(p => {
                left -= 1
                val n = q.dequeue()
                val m = g(n).head
                g(m) -= n
                if (g(m).size == 1) q.enqueue(m) 
            })
        }
        q.toList
    }
}
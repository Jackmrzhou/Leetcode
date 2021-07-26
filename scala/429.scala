import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
object Solution {
    def levelOrder(root: Node): List[List[Int]] = {
        val q = Queue[Node]()
        if (root == null) Nil
        else {
            val res = ListBuffer[List[Int]]()
            q.enqueue(root)
            while (q.nonEmpty) {
                val level = ListBuffer[Int]()
                for (i <- 0 until q.size) {
                    val n = q.dequeue()
                    q.enqueueAll(n.children)
                    level += n.value
                }
                res += level.toList
            }
            res.toList
        }
    }
}
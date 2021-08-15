import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
object Solution {
    def largestValues(root: TreeNode): List[Int] = {
        if (root == null) return Nil
        val q = Queue[TreeNode]()
        var res = ListBuffer[Int]()
        q.enqueue(root)
        while (q.nonEmpty) {
            val size = q.size
            var max = q.front
            for (i <- 0 until size) {
                val n = q.dequeue()
                if (n.left != null) q.enqueue(n.left)
                if (n.right != null) q.enqueue(n.right)
                if (n.value > max.value) max = n
            }
            res += max.value
        }
        res.toList
    }
}
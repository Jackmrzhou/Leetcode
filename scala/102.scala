import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
object Solution {
    def levelOrder(root: TreeNode): List[List[Int]] = {
        val q = Queue[TreeNode]()
        if (root != null)
          q.enqueue(root)
        val res = ListBuffer[List[Int]]()
        while (!q.isEmpty) {
            val s = q.size
            val level = ListBuffer[Int]()
            for (i <- 0 until s) {
                val n = q.dequeue()
                level += n.value
                if (n.left != null) q.enqueue(n.left)
                if (n.right != null) q.enqueue(n.right)
            }
            res += level.toList
        }
        res.toList
    }
}
import scala.collection.mutable.Queue
object Solution {
    def findBottomLeftValue(root: TreeNode): Int = {
        val q = Queue[TreeNode]()
        var res: Int = 0
        q.enqueue(root)
        while (q.nonEmpty) {
            val size = q.size
            res = q.front.value
            for (i <- 0 until size) {
                val n = q.dequeue()
                if (n.left != null) q.enqueue(n.left)
                if (n.right != null) q.enqueue(n.right)
            }
        }
        res
    }
}
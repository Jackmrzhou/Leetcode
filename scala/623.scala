import scala.collection.mutable.Queue
object Solution {
    def addOneRow(root: TreeNode, `val`: Int, depth: Int): TreeNode = {
        if (depth == 1) {
            return new TreeNode(_value=`val`, _left = root)
        }
        val q = Queue[TreeNode]()
        q.enqueue(root)
        var level = 1
        while (level < depth-1) {
            val size = q.size
            for (i <- 0 until size) {
                val n = q.dequeue()
                if (n.left != null) q.enqueue(n.left)
                if (n.right != null) q.enqueue(n.right)
            }
            level += 1
        }
        while (!q.isEmpty) {
            val n = q.dequeue()
            val l = new TreeNode(_value=`val`)
            val r = new TreeNode(_value=`val`)
            l.left = n.left
            r.right = n.right
            n.left = l
            n.right = r
        }
        root
    }
}
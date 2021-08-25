import scala.collection.mutable.ListBuffer
object Solution {
    def bstToGst(root: TreeNode): TreeNode = {
        val list = ListBuffer[Tuple2[TreeNode, Int]]()
        var sum = 0
        def inorder(root:TreeNode) {
            if (root != null) {
                inorder(root.left)
                sum += root.value
                list += Tuple2(root, sum)
                inorder(root.right)
            }
        }
        inorder(root)
        for (r <- list) {
            r._1.value += sum - r._2
        }
        root
    }
}
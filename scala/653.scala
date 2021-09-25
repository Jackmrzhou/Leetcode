import scala.collection.mutable.Set
object Solution {
    def findTarget(root: TreeNode, k: Int): Boolean = {
        val set = Set[Int]()
        def dfs(root: TreeNode): Boolean = {
            if (root == null) false
            else if (set.contains(k-root.value)) {
                true
            } else {
                set += root.value
                dfs(root.left) || dfs(root.right)
            }
        }
        dfs(root)
    }
}
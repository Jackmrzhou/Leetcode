import scala.collection.mutable
object Solution {
    def rob(root: TreeNode): Int = {
        var mem = mutable.Map[(TreeNode, Boolean), Int]()
        def r(root: TreeNode, can: Boolean): Int = {
            if (mem.contains((root, can))) mem((root, can))
            else if (root == null) 0
            else if (can) {
                var res = r(root.left, false)+r(root.right, false)+root.value
                res = res.max(r(root.left, true) + r(root.right, true))
                mem += ((root, can) -> res)
                res
            } else {
                val res = r(root.left, true) + r(root.right, true)
                mem += ((root, can) -> res)
                res
            }
        }
        r(root, true)
    }
}
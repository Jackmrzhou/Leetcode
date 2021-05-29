object Solution {
    def flatten(root: TreeNode): Unit = {
        def f(root: TreeNode): TreeNode = {
          if (root == null) null
          else if (root.left == null) {
            if (root.right == null) root
            else f(root.right)
          } else {
            val r = root.right
            val lTail = f(root.left)
            val rTail = f(root.right)
            root.right = root.left
            root.left = null
            lTail.right = r
            if (rTail == null) lTail else rTail
          }
        }
        f(root)
    }
}
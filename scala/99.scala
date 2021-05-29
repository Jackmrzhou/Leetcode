object Solution {
    def recoverTree(root: TreeNode): Unit = {
        var x:TreeNode = null
        var y:TreeNode = null
        var prev: TreeNode = null
        def inorder(root: TreeNode) {
          if (root == null) return
          inorder(root.left)
          if (prev != null && root.value < prev.value) {
            x = root
            if (y==null)
              y = prev
            else return
          }
          prev = root
          inorder(root.right)
        }
        inorder(root)
        def swap(x: TreeNode, y: TreeNode) {
          val tmp = x.value
          x.value = y.value
          y.value = tmp
        }
        swap(x, y)
    }
}
object Solution {
    def isValidBST(root: TreeNode): Boolean = {
        def test(root: TreeNode, min:Long, max: Long): Boolean = {
          if (root == null) true
          else if (root.value <= min || root.value >= max) false
          else test(root.left, min, root.value) && test(root.right, root.value, max)
        }
        test(root, Long.MinValue, Long.MaxValue)
    }
}
object Solution {
    def isBalanced(root: TreeNode): Boolean = {
        def maxDepth(root: TreeNode): Int = {
            if (root == null) return 0
            return maxDepth(root.left).max(maxDepth(root.right)) + 1
        }
        if (root == null) return true
        (maxDepth(root.left)-maxDepth(root.right)).abs <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }
}

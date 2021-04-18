object Solution {
    def minDepth(root: TreeNode): Int = {
        if (root == null) return 0
        if (root.left == null) return 1+minDepth(root.right)
        if (root.right == null) return 1+minDepth(root.left)
        minDepth(root.left).min(minDepth(root.right)) + 1
    }
}

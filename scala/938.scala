object Solution {
    def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
        if (root == null) return 0
        if (root.value > high) return rangeSumBST(root.left, low, high)
        if (root.value < low) return rangeSumBST(root.right, low, high)
        root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
}

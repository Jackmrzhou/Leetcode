object Solution {
    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        def visit(r: TreeNode, curSum: Int, target: Int): Boolean = {
            if (r == null) return curSum == target
            if (r.left == null) return visit(r.right, curSum + r.value, target)
            if (r.right == null) return visit(r.left, curSum + r.value, target)
            visit(r.left, curSum + r.value, target) || visit(r.right, curSum + r.value, target)
        }
        if (root == null) return false
        visit(root, 0, targetSum)
    }
}

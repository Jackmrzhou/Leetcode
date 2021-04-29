object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root == p || root == q) return root
        if (root == null) return null
        val l = lowestCommonAncestor(root.left, p, q)
        val r = lowestCommonAncestor(root.right, p, q)
        if (l == null) return r
        if (r == null) return l
        root
    }
}

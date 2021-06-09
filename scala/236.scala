object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root == p || root == q || root == null) {
           root 
        } else {
            val l = lowestCommonAncestor(root.left, p, q)
            var r = lowestCommonAncestor(root.right, p, q)
            if (l != null && r != null) root
            else if (l != null) l
            else r
        }
    }
}
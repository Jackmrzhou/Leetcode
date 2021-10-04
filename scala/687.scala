object Solution {
    def longestUnivaluePath(root: TreeNode): Int = {
        var res = 0
        def dfs(root: TreeNode): Int = {
            if (root == null) {
               0
            } else {
                val l = dfs(root.left)
                val r = dfs(root.right)
                val ll = if (root.left != null && root.value == root.left.value) l + 1 else 0
                val rr = if (root.right != null && root.value == root.right.value) r + 1 else 0
                res = res.max(ll+rr)
                ll.max(rr)
            }
        }
        dfs(root)
        res
    }
}
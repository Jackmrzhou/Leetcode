object Solution {
    def diameterOfBinaryTree(root: TreeNode): Int = {
        var res = 0
        def dfs(root:TreeNode): Int = {
            if (root == null) -1
            else {
                val l = dfs(root.left)+1
                var r = dfs(root.right)+1
                res = res.max(r+l)
                r.max(l)
            }
        }
        dfs(root)
        res
    }
}
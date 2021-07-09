object Solution {
    def minDiffInBST(root: TreeNode): Int = {
        var last = 2 * 100000 + 1
        var res = 100000 + 1
        def inorder(r :TreeNode) {
            if (r == null) return 
            inorder(r.left)
            val diff = (r.value - last).abs
            res = res.min(diff)
            last = r.value
            inorder(r.right)
        }
        inorder(root)
        res
    }
}
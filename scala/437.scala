object Solution {
    def pathSum(root: TreeNode, targetSum: Int): Int = {   
        def ps(root: TreeNode, t: Int): Int = {
            if (root == null) {
                0
            } else if (t-root.value == 0) {
                ps(root.left, t-root.value) + ps(root.right, t-root.value) + 1
            } else {
                ps(root.left, t - root.value) + ps(root.right, t - root.value)
            }
        }
        var res = ps(root, targetSum)
        def dfs(root: TreeNode) {
            if (root != null ) {
                res += ps(root.left, targetSum) + ps(root.right, targetSum)
                dfs(root.left)
                dfs(root.right)
            }
        }
        dfs(root)
        res
    }
}
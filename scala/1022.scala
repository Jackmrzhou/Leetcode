object Solution {
    def sumRootToLeaf(root: TreeNode): Int = {
        var sum = 0
        def dfs(root: TreeNode, num: Int): Unit ={
            if (root.left == null && root.right == null) sum += num*2 + root.value
            if (root.left != null)
                dfs(root.left, num*2+root.value)
            if (root.right != null)
                dfs(root.right, num*2+root.value)
        }
        dfs(root, 0)
        sum
    }
}

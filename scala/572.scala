object Solution {
    def isSubtree(root: TreeNode, subRoot: TreeNode): Boolean = {
        def isSameTree(root: TreeNode, subRoot: TreeNode):Boolean = {
            if(root == null || subRoot == null) root == null && subRoot == null
            else if(root.value == subRoot.value) isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)
            else false
        }
        
        def dfs(root: TreeNode): Boolean = {
            if (root == null) false
            else {
                if (isSameTree(root, subRoot)) true
                else dfs(root.left) || dfs(root.right)
            }
        }
        dfs(root)
    }
}
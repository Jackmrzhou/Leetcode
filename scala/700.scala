object Solution {
    def searchBST(root: TreeNode, `val`: Int): TreeNode = {
        if (root == null) return null
        if (root.value == `val`) return root
        if (root.value < `val`) return searchBST(root.right, `val`)
        return searchBST(root.left, `val`)
    }
}

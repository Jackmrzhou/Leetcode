object Solution {
    def sumOfLeftLeaves(root: TreeNode): Int = {
        if (root == null) return 0                              
        if (root.left != null && root.left.left == null && root.left.right == null) return root.left.value + sumOfLeftLeaves(root.right)
        else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
    }
}

object Solution {
    def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = {
        if (root1 == null) root2
        else if (root2 == null) root1
        else {
            val n = new TreeNode()
            n.value = root1.value + root2.value
            n.left = mergeTrees(root1.left, root2.left)
            n.right = mergeTrees(root1.right, root2.right)
            n
        }
    }
}

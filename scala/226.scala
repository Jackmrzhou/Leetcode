object Solution {
    def invertTree(root: TreeNode): TreeNode = {
        if (root == null) return null
        val t = (invertTree(root.right), invertTree(root.left))
        root.left = t._1
        root.right = t._2
        root
    }
}

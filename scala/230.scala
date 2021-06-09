object Solution {
    def kthSmallest(root: TreeNode, k: Int): Int = {
        var i = 1
        def inorder(root: TreeNode): TreeNode = {
            if (root == null) return null
            val l = inorder(root.left)
            if (l != null) return l
            if (i == k) return root
            i += 1
            inorder(root.right)
        }
        inorder(root).value
    }
}
object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) return List[Int]()
        inorderTraversal(root.left) ::: List[Int](root.value) ::: inorderTraversal(root.right)
    }
}

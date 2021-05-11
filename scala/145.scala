object Solution {
    def postorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) return Nil
        postorderTraversal(root.left) ::: postorderTraversal(root.right) ::: List[Int](root.value)
    }
}

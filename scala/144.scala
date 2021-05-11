object Solution {
    def preorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) return Nil
        List[Int](root.value) ::: preorderTraversal(root.left) ::: preorderTraversal(root.right)
    }
}

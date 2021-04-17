object Solution {
    def isSymmetric(root: TreeNode): Boolean = {
        def f(l:TreeNode, r:TreeNode):Boolean = {
            (l, r) match {
                case (null, null) => true
                case (null, _) | (_, null) => false
                case (l, r) => l.value == r.value && f(l.left, r.right) && f(l.right, r.left)
            }
        }
        f(root.left, root.right)
    }
}

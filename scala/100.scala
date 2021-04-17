object Solution {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
       (p, q) match {
           case (null, null) => true
           case (null, _) | (_, null) => false
           case (p, q) => p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
       }
    }
}

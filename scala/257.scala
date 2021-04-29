object Solution {
    def binaryTreePaths(root: TreeNode): List[String] = {
        var res = List[String]()
        def walk(root: TreeNode, path: List[Int]): Unit = {
          if (root.left == null && root.right == null) res = res :+ (path:+root.value).mkString("->")
          if (root.left != null) walk(root.left, path :+ root.value)
          if (root.right != null) walk(root.right, path :+ root.value)
        }
        walk(root, List[Int]())
        res
    }
}

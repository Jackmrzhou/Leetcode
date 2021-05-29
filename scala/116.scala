object Solution {
    def connect(root: Node): Node = {
        def c(root: Node, right: Node) {
          if (root != null) {
            root.next = right
            c(root.left, root.right)
            c(root.right, if (right == null) null else right.left)
          }
        }
        c(root, null)
        root
    }
}
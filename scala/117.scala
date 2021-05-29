object Solution {
    def findNext(root: Node): Node = {
      if (root == null) null
      else if (root.left != null) root.left
      else if (root.right != null) root.right
      else findNext(root.next)
    }
    def connect(root: Node): Node = {
        if (root == null) return null
        if (root.left != null) {
          if (root.right != null)
            root.left.next = root.right
          else 
            root.left.next = findNext(root.next)
        }
        if (root.right != null) {
          root.right.next = findNext(root.next)
        }
        connect(root.right)
        connect(root.left)
        root
    }
}
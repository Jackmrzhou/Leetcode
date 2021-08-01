object Solution {
    def merge(l: TreeNode, r: TreeNode): TreeNode = {
        if (l == null) r
        else if (r == null) l
        else {
            var ptr = l
            while (ptr.right != null) ptr = ptr.right
            ptr.right = r
            l
        }
    }
    def deleteNode(root: TreeNode, key: Int): TreeNode = {
        if (root == null) null
        else if (root.value == key) {
            merge(root.left, root.right)
        } else {
            if (root.value > key) root.left = deleteNode(root.left, key)
            else root.right = deleteNode(root.right, key)
            root
        }
    }
}
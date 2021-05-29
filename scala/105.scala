object Solution {
    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
        if (preorder.isEmpty) null 
        else {
            val root = TreeNode(preorder.head)
            val i = inorder.indexWhere(_ == preorder.head)
            root.left = buildTree(preorder.slice(1, 1+i), inorder.slice(0, i))
            root.right = buildTree(preorder.slice(1+i, preorder.length), inorder.slice(i+1, inorder.length))
            root
        }
    }
}
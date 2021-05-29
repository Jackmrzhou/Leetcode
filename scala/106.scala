object Solution {
    def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
        if (inorder.isEmpty) null 
        else {
            val root = TreeNode(postorder.last)
            val i = inorder.indexWhere(_ == postorder.last)
            root.left = buildTree(inorder.slice(0, i), postorder.slice(0, i))
            root.right = buildTree(inorder.slice(i+1, inorder.length), postorder.slice(i, postorder.length-1))
            root
        }
    }
}
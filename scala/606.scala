object Solution {
    def tree2str(root: TreeNode): String = {
        if (root == null) ""
        else {
            val needLeft = root.right != null
            if (needLeft) s"${root.value}(${tree2str(root.left)})(${tree2str(root.right)})"
            else if (root.left != null) s"${root.value}(${tree2str(root.left)})"
            else s"${root.value}"
        }
    }
}

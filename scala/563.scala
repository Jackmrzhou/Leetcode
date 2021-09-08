object Solution {
    def findTilt(root: TreeNode): Int = {
        var res = 0
        def sumTree(root: TreeNode): Int = {
            if (root == null) 0
            else {
                val l = sumTree(root.left)
                val r = sumTree(root.right)
                res += (l-r).abs
                l+r+root.value
            }
        }
        sumTree(root)
        res
    }
}

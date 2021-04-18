object Solution {
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        if (nums.length == 0) return null
        val l = 0
        val r = nums.length
        val mid = (l + r) / 2
        val root = TreeNode(nums(mid))
        root.left = sortedArrayToBST(nums.slice(l, mid))
        root.right = sortedArrayToBST(nums.slice(mid+1, r))
        root
    }
}

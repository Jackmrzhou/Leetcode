object Solution {
    def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
        if (nums.length == 0) null
        else {
            var maxIndex = -1
            for (i <- 0 until nums.length) {
                if (maxIndex == -1 || nums(i) > nums(maxIndex)) {
                    maxIndex = i
                }
            }
            new TreeNode(_value = nums(maxIndex),
                         _left = constructMaximumBinaryTree(nums.slice(0, maxIndex)), 
                         _right = constructMaximumBinaryTree(nums.slice(maxIndex+1, nums.length)))
        }
    }
}
object Solution {
    def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
        def dfs(root: TreeNode, path: List[Int], sum: Int): List[List[Int]] = {
          if (root == null) Nil
          else if (root.left == null && root.right == null) {
            if (sum+root.value == targetSum) List(path :+ root.value)
            else Nil
          } else {
            dfs(root.left, path :+ root.value, sum+root.value) ::: dfs(root.right, path :+ root.value, sum+root.value)
          }
        }
        dfs(root, Nil, 0)
    }
}
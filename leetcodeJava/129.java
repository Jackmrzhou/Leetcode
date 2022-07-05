package leetcodeJava;

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int cur) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return cur*10+root.val;
        }
        return dfs(root.left, cur*10+ root.val) + dfs(root.right, cur*10+root.val);
    }
}

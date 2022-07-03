package leetcodeJava;

class Solution {
    public void recoverTree(TreeNode root) {
        dfs(root);
        var tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private TreeNode prev = null;
    
    private TreeNode first = null, second = null;
    
    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            if (prev == null) {
                prev = root;
            } else {
                if (root.val < prev.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = root;
                }
                prev = root;
            }
            dfs(root.right);
        }
    }
}

package leetcodeJava;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return test(root, -(1l<<40), 1l<<40);
    }
    
    private boolean test(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return test(root.left, min, root.val) && test(root.right, root.val, max);
    }
}

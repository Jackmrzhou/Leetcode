package leetcodeJava;

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            var right = root.left;
            var tail = right;
            while(tail.right != null) {
                tail = tail.right;
            }
            tail.right = root.right;
            root.left = null;
            root.right = right;
        }
    }
}

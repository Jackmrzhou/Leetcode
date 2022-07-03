package leetcodeJava;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        var res = new LinkedList<List<Integer>>();
        while (q.size() != 0) {
            var level = new LinkedList<Integer>();
            var size = q.size();
            for (var i = 0; i < size; i++) {
                var node = q.pop();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}

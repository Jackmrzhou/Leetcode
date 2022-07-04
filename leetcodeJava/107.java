package leetcodeJava;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        var res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        q.add(root);
        while(q.size() != 0) {
            var size = q.size();
            var level = new LinkedList<Integer>();
            for (var i = 0; i < size; i++) {
                var n = q.pop();
                level.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}

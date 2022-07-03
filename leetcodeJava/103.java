package leetcodeJava;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        var res = new LinkedList<List<Integer>>();
        var flag = false;
        while (q.size() != 0) {
            var level = new LinkedList<Integer>();
            var size = q.size();
            for (var i = 0; i < size; i++) {
                var node = q.pop();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (flag) Collections.reverse(level);
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}

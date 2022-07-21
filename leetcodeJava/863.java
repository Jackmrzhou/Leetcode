package leetcodeJava;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var path = new LinkedList<TreeNode>();
        var res = new LinkedList<Integer>();
        find(root, target, path);
        for (int i = 0; i < path.size(); i++) {
            int d = k-path.size() + i;
            if (d < 0) continue;
            var node = path.get(i);
            if (d == 0) res.add(node.val);
            else {
                var next = target;
                if (i < path.size()-1) {
                    next = path.get(i+1);
                }
                if (node.left == next) res.addAll(dk(node.right, d-1, target));
                else res.addAll(dk(node.left, d-1, target));
            }
        }
        res.addAll(dk(target, k, null));
        return res;
    }
    
    private boolean find(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        if (root == null) return false;
        if (target == root) return true;
        path.add(root);
        if (find(root.left, target, path)) return true;
        if (find(root.right, target, path)) return true;
        path.removeLast();
        return false;
    }
    
    private List<Integer> dk(TreeNode root, int k, TreeNode cut) {
        if (root == cut) return new LinkedList();
        if (root == null) return new LinkedList();
        if (k == 0) return List.of(Integer.valueOf(root.val));
        var res = new LinkedList<Integer>();
        var tmp = dk(root.left, k-1, cut);
        if (tmp != null) res.addAll(tmp);
        tmp = dk(root.right, k-1, cut);
        if (tmp != null) {
            res.addAll(tmp);
        }
        return res;
    }
}

package leetcodeJava;

class Solution {
    class pair {
        TreeNode node; 
        int depth;
        public pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root, 0).node;
    }
    
    private pair dfs(TreeNode root, int depth) {
        if (root == null) {
            return new pair(null, depth);
        }
        var l = dfs(root.left, depth+1);
        var r = dfs(root.right, depth+1);
        if (l.depth > r.depth) {
            return l;
        } else if (l.depth == r.depth) {
            return new pair(root, l.depth);
        } else {
            return r;
        }
    }
}

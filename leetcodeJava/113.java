package leetcodeJava;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        dfs(root, new LinkedList<TreeNode>(), 0, targetSum, res);
        return res;
    }
    
    private void dfs(TreeNode root, LinkedList<TreeNode> path, int sum, int target, List<List<Integer>> res) {
        path.add(root);
        sum = sum + root.val;
        if (sum == target && root.left == null && root.right == null) {
            res.add(path.stream().map(n -> Integer.valueOf(n.val)).collect(Collectors.toList()));
        }
        if (root.left != null)
            dfs(root.left, path, sum, target, res);
        if (root.right != null)
            dfs(root.right, path, sum, target, res);
        if (path.size() != 0)
            path.removeLast();
    }
}

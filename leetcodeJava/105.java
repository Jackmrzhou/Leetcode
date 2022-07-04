package leetcodeJava;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(Arrays.stream(preorder).boxed().collect(Collectors.toList()), Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }
    
    private TreeNode build(List<Integer> pre, List<Integer> in) {
        if (pre.size() == 0) return null;
        var n = pre.get(0);
        TreeNode root = null;
        var i = in.indexOf(n);
        root = new TreeNode(n);
        root.left = build(pre.subList(1, 1+i), in.subList(0, i));
        root.right = build(pre.subList(1+i, pre.size()), in.subList(i+1, in.size()));
        return root;
    }
}

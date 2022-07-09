package leetcodeJava;

class BSTIterator {
    
    LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        var ptr = root;
        while(ptr != null) {
            stack.add(ptr);
            ptr = ptr.left;
        }
    }
    
    public int next() {
        var n = stack.removeLast();
        if (n.right != null) {
            var ptr = n.right;
            while (ptr != null) {
                stack.add(ptr);
                ptr = ptr.left;
            }
        }
        return n.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

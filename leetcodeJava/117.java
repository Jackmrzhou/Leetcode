package leetcodeJava;

class Solution {
    private Node findNext(Node root) {
        if (root == null) return null;
        else if (root.left != null) return root.left;
        else if (root.right != null) return root.right;
        else return findNext(root.next);
    }
    
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root.next);
            }
        } 
        if (root.right != null) {
            root.right.next = findNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}

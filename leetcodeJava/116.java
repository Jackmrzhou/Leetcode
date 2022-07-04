package leetcodeJava;

public Node connect(Node root) {
        if (root == null) return null;
        Node l = root.left, r = root.right;
        while (l != null) {
            l.next = r;
            l = l.right;
            r = r.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

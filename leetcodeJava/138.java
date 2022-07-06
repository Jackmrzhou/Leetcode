package leetcodeJava;

class Solution {
    private Map<Node, Node> visitMap = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        var n = visitMap.get(head);
        if (n != null) return n;
        var node = new Node(head.val);
        visitMap.put(head, node);
        node.next = copyRandomList(head.next);
        if (head.random == null) node.random = null;
        else node.random = visitMap.get(head.random);
        return node;
    }
}

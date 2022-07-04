package leetcodeJava;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        var root = new TreeNode(slow.val);
        if (prev != null) prev.next = null;
        if (slow == head) root.left = null;
        else root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}

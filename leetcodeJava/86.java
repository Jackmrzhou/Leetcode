package leetcodeJava;

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode l1 = new ListNode(), l2 = new ListNode();
        ListNode t1 = l1, t2 = l2;
        var ptr = head;
        while(ptr != null) {
            if (ptr.val < x) {
                t1.next = new ListNode(ptr.val);
                t1 = t1.next;
            } else {
                t2.next = new ListNode(ptr.val);
                t2 = t2.next;
            }
            ptr = ptr.next;
        }
        t1.next = l2.next;
        return l1.next;
    }
}

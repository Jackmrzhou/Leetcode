package leetcodeJava;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        var next = slow.next;
        slow.next = null;
        var l1 = sortList(head);
        var l2 = sortList(next);
        var l3 = new ListNode();
        var newHead = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                next = l1.next;
                l1.next = null;
                l1 = next;
                l3 = l3.next;
            } else {
                l3.next = l2;
                next = l2.next;
                l2.next = null;
                l2 = next;
                l3 = l3.next;
            }
        }
        if (l1 != null) l3.next = l1;
        else if (l2 != null) l3.next = l2;
        return newHead.next;
    }
}

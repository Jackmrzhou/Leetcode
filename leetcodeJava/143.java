package leetcodeJava;

class Solution {
    public void reorderList(ListNode head) {
        var desc = new ListNode();
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        if (slow == null || slow.next == null) return;
        var n = slow.next;
        slow.next = null;
        slow = n;
        while (slow != null) {
            var next = slow.next;
            slow.next = desc.next;
            desc.next = slow;
            slow = next;
        }
        fast = head;
        while(fast != null) {
            var next = fast.next;
            fast.next = desc.next;
            if (desc.next != null)
                desc.next = desc.next.next;
            if (fast.next != null)
                fast.next.next = next;
            fast = next;
        }
    }
}

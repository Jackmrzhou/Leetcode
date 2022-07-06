package leetcodeJava;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        slow = traversal(slow, fast);
        fast = slow;
        if (slow.next == null) return null;
        var ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode traversal(ListNode slow, ListNode fast) {
        do {
            if (slow.next != null) slow = slow.next;
            if (fast.next != null) fast = fast.next;
            if (fast.next != null) fast = fast.next;
        } while(slow != fast);
        return slow;
    }
}


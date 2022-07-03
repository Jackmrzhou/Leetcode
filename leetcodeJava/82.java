package leetcodeJava;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next != null && head.next.val != head.val)
            return remove(head, new ListNode(101));
        if (head.next == null) return head;
        return remove(head, head);
    }
    
    private ListNode remove(ListNode head, ListNode last) {
        if (head == null) return null;
        if (head.val == last.val) return remove(head.next, last);
        else {
            if (head.next != null && head.next.val != head.val) {
                head.next = remove(head.next, head);
                return head;
            }
            if (head.next == null) return head;
            return remove(head.next, head);
        }
    }
}

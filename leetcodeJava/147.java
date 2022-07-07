package leetcodeJava;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        var dummyHead = new ListNode(-5001);
        ListNode tail = null;
        var ptr = head;
        while(ptr != null) {
            var next = ptr.next;
            add(dummyHead, ptr);
            ptr = next;
        }
        return dummyHead.next;
    }
    
    private void add(ListNode head, ListNode node) {
        var ptr = head;
        var prev = ptr;
        while (ptr != null) {
            if (ptr.val >= node.val) break;
            prev = ptr;
            ptr = ptr.next;
        }
        prev.next = node;
        node.next = ptr;
    }
}

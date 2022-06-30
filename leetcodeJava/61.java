package leetcodeJava;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        var ptr = head;
        var tail = head;
        var l = 0;
        while (ptr != null) {
            l++;
            tail = ptr;
            ptr = ptr.next;
        }
        if (l == 0) return null;
        k = (l - k % l) % l;
        if (k == 0) return head;
        ptr = head;
        var tail2 = ptr;
        while (k != 0) {
            tail2 = ptr;
            ptr = ptr.next;
            k--;
        }
        tail.next = head;
        tail2.next = null;
        return ptr;
    }
}

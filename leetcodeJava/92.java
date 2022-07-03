package leetcodeJava;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tail = null, tail2 = null;
        var dummyHead = new ListNode(0, head);
        var ptr = dummyHead;
        var index = 0;
        while (ptr != null) {
            var next = ptr.next;
            if (index == left-1) {
                tail = ptr;
                tail.next = null;
            }
            if (index >= left && index <= right) {
                if (tail.next == null) tail2 = ptr;
                ptr.next = tail.next;
                tail.next = ptr;
            }
            if (index == right) {
                tail2.next = next;
                break;
            }
            index++;
            ptr = next;
        }
        return dummyHead.next;
    }
}

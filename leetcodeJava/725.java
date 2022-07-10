package leetcodeJava;

class Solution {
    private ListNode NextN(ListNode head, int n) {
        if (head == null) return null;
        var ptr = head;
        while (n > 1) {
            ptr = ptr.next;
            n--;
        }
        ListNode next = null;
        if (ptr != null) {
            next = ptr.next;
            ptr.next = null;
        }
        return next;
        
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        var ptr = head;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }
        
        var left = len % k;
        var res = new ListNode[k];
        var cur = head;
        for (int i = 0; i < k; i++) {
            var each = len / k;
            if (left != 0) {
                each++;
                left--;
            }
            var tmp = NextN(cur, each);
            res[i] = cur;
            cur = tmp;
        }
        return res;
    }
}

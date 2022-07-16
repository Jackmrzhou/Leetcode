package leetcodeJava;

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) set.add(Integer.valueOf(num));
        
        var ptr = head;
        var res = 0;
        var flag = false;
        while (ptr != null) {
            if (set.contains(Integer.valueOf(ptr.val))) {
                if (!flag) {
                    flag = true;
                    res++;
                }
            } else {
                flag = false;
            }
            ptr = ptr.next;
        }
        return res;
    }
}

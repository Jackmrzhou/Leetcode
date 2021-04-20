object Solution {
    def hasCycle(head: ListNode): Boolean = {
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            fast = fast.next.next
            slow = slow.next
            if (slow == fast) {
                return true
            }
        }
        false
    }
}

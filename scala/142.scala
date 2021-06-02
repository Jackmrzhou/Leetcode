object Solution {
    def detectCycle(head: ListNode): ListNode = {
        if (head == null || head.next == null) return null
        var slow = head
        var fast = head
        do {
          slow = slow.next
          fast = fast.next
          if (fast != null)
              fast = fast.next
        } while (slow != fast && slow != null && fast != null)
        if (slow == null || fast == null) return null
        slow = head
        while (fast != slow) {
          fast = fast.next
          slow = slow.next
        }
        slow
    }
}
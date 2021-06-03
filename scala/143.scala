object Solution {
    def reverse(head: ListNode): ListNode = {
      val dummy = new ListNode()
      var ptr = head
      while (ptr != null) {
        val h = dummy.next
        dummy.next = ptr
        ptr = ptr.next
        dummy.next.next = h
      }
      dummy.next
    }
    def reorderList(head: ListNode): Unit = {
        var slow = head
        var fast = head.next
        while(fast != null && fast.next != null) {
          slow = slow.next
          fast = fast.next.next
        }
        fast = reverse(slow.next)
        slow.next = null
        slow = head
        while (slow != null) {
          val succ = slow.next
          slow.next = fast
          if (fast != null) {
            fast = fast.next
            slow.next.next = succ
          }
          slow = succ
        }
    }
}
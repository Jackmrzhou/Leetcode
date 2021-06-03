object Solution {
    def insertionSortList(head: ListNode): ListNode = {
        val dummy = new ListNode(-5001)
        var ptr = head
        var e = dummy
        var prev = dummy
        while (ptr != null) {
          e = dummy
          prev = dummy
          while (ptr.x > e.x && e.next != null) {
            prev = e
            e = e.next
          }
          val n = ptr.next
          if (ptr.x > e.x) {
            e.next = ptr
            ptr.next = null
            ptr = n
          } else {
            ptr.next = e
            prev.next = ptr
            ptr = n
          }
        }
        dummy.next
    }
}
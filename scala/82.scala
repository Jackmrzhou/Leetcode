object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {
        if (head == null || head.next == null) return head
        else if (head.next.x == head.x) {
          var ptr = head
          while (ptr != null && ptr.x == head.x) ptr = ptr.next
          deleteDuplicates(ptr)
        }
        else {
          head.next = deleteDuplicates(head.next)
          head
        }
    }
}
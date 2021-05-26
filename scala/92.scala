object Solution {
    def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
        def reverse(head: ListNode, k: Int): ListNode = {
          if (head == null) return head
          if (k < left || k >= right) {
            head.next = reverse(head.next, k+1)
            head
          }
          else {
            val tail = reverse(head.next, k+1)
            val s = head.next.next
            head.next.next = head
            head.next = s
            tail
          }
        }
        reverse(head, 1)
    }
}
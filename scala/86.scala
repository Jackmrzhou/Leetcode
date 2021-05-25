object Solution {
    def partition(head: ListNode, x: Int): ListNode = {
        val less = ListNode()
        val greater = ListNode()
        var lessTail = less
        var greaterTail = greater
        var ptr = head
        while(ptr != null) {
          if (ptr.x < x) {
            lessTail.next = ptr
            ptr = ptr.next
            lessTail.next.next = null
            lessTail = lessTail.next
          } else {
            greaterTail.next = ptr
            ptr = ptr.next
            greaterTail.next.next = null
            greaterTail = greaterTail.next
          }
        }
        lessTail.next = greater.next
        less.next
    }
}
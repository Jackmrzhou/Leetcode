object Solution {
    def reverseList(head: ListNode): ListNode = {
        if (head == null) return null 
        if (head.next == null) return head
        val last = reverseList(head.next)
        head.next.next = head
        head.next = null
        last
    }
}

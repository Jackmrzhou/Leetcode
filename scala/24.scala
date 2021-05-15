object Solution {
    def swapPairs(head: ListNode): ListNode = {
        if (head == null || head.next == null) head
        else {
            val n = head.next
            val rest = n.next
            n.next = head
            head.next = swapPairs(rest)
            n
        }
    }
}

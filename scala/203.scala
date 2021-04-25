object Solution {
    def removeElements(head: ListNode, `val`: Int): ListNode = {
        if (head == null) return null
        if (head.x == `val`) return removeElements(head.next, `val`)
        head.next  = removeElements(head.next, `val`)
        return head
    }
}

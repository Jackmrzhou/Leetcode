object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        val dummyHead = ListNode(0, head)
        var ptr = dummyHead
        for (i <- 0 until n+1) ptr = ptr.next
        var nPtr = dummyHead
        while (ptr != null) {
            nPtr = nPtr.next
            ptr = ptr.next
        }
        nPtr.next = nPtr.next.next
        dummyHead.next
    }
}

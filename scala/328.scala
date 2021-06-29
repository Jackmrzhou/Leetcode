object Solution {
    def oddEvenList(head: ListNode): ListNode = {
        if (head == null) return null
        val d1 = new ListNode()
        val d2 = new ListNode()
        var t1 = d1
        var t2 = d2
        var ptr = head
        var counter = 0
        while (ptr != null) {
            val tmp = ptr
            ptr = ptr.next
            tmp.next = null
            if (counter % 2 == 0) {   
                t1.next = tmp
                t1 = t1.next
            } else {
                t2.next = tmp
                t2 = t2.next
            }
            counter += 1
        }
        t1.next = d2.next
        d1.next
    }
}
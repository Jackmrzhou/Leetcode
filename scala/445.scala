object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        def reverseList(head: ListNode): ListNode = {
            if (head == null) return null 
            if (head.next == null) return head
            val last = reverseList(head.next)
            head.next.next = head
            head.next = null
            last
        }
        def add(x: ListNode, y: ListNode, carry: Int): ListNode = {
            (x, y) match {
                case (null, null) => if (carry == 1) ListNode(1, null) else null
                case (n1, n2) => {
                    if (n1 == null || n2 == null) {
                        val n = if (n1==null) n2 else n1
                        val newCarry = if (n.x + carry == 10) {n.x = 0; 1} else {n.x += carry; 0}
                        n.next = add(n.next, null, newCarry)
                        n
                    } else {
                        val newCarry = if (n1.x + n2.x+carry >= 10) {n1.x += carry+n2.x-10; 1} else {n1.x += carry+n2.x; 0}
                        n1.next = add(n1.next, n2.next, newCarry)
                        n1
                    }
                }
            }
        }
        val _l1 = reverseList(l1)
        val _l2 = reverseList(l2)
        reverseList(add(_l1, _l2, 0))
    }
}
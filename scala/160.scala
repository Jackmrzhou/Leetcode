object Solution {
    def forwardK(head: ListNode, k: Int): ListNode = {
        var ptr = head
        for (i <- 1 to k) ptr = ptr.next
        ptr
    }
    def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
        if (headA == null || headB == null) return null
        if (headA == headB) return headA
        var ptrA = headA
        var ptrB = headB
        var lengthA = 1
        var lengthB = 1
        while (ptrA.next != null){ 
            ptrA = ptrA.next
            lengthA += 1
        }
        while (ptrB.next != null) {
            ptrB = ptrB.next
            lengthB += 1
        }
        if (ptrA != ptrB) return null
        ptrA = headA
        ptrB = headB
        if (lengthA > lengthB) ptrA = forwardK(headA, lengthA - lengthB)
        if (lengthB > lengthA) ptrB = forwardK(headB, lengthB - lengthA)
        while (ptrA != null) {
            if (ptrA == ptrB) return ptrA
            ptrA = ptrA.next
            ptrB = ptrB.next
        }
        return null
    }
}

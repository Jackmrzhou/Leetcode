object Solution {
    def sortList(head: ListNode): ListNode = {
        if (head == null) return null
        if (head.next == null) return head
        var slow = head
        var fast = head.next
        while (fast != null && fast.next != null) {
          slow = slow.next
          fast = fast.next.next
        }
        val n = slow.next
        slow.next = null
        val l = sortList(head)
        var r = sortList(n)
        merge(l, r)
    }
    def merge(l: ListNode, r: ListNode): ListNode = {
        if (l == null) return r
        else if (r == null) return l
        val dummy = new ListNode(-100001)
        var ptrL = l
        var ptrR = r
        var ptr = dummy
        while (ptrL != null && ptrR != null) {
          if (ptrL.x < ptrR.x) {
            ptr.next = ptrL
            ptr = ptrL
            ptrL = ptrL.next
          } else {
            ptr.next = ptrR
            ptr = ptrR
            ptrR = ptrR.next
          }
        }
        if (ptrL != null) {
          ptr.next = ptrL
        }
        if (ptrR != null) {
          ptr.next = ptrR
        }
        dummy.next
    }
}
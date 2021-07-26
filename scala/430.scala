object Solution {
    def flatten(head: Node): Node = {
        def helper(head: Node): Node = {
            if (head == null) null
            else {
                var ptr = head
                while (true) {
                    if (ptr.child != null) {
                        val tail = helper(ptr.child)
                        tail.next= ptr.next
                        if (ptr.next != null)
                            tail.next.prev = tail
                        ptr.next = ptr.child
                        ptr.next.prev = ptr
                        ptr.child = null
                        if (tail.next != null)
                            ptr = tail.next
                        else ptr = tail
                    } 
                    if (ptr.next == null) return ptr
                    else ptr = ptr.next
                }
                null
            }
        }
        helper(head)
        head
    }
}
object Solution {
    def rotateRight(head: ListNode, k: Int): ListNode = {
        if (head == null) null 
        else {
          var ptr = head 
          var length = 1
          var tail = ptr
          while (ptr.next != null) {
            length += 1
            ptr = ptr.next
          }
          tail = ptr
          var moves = (length - k % length)%length
          ptr = head
          while(moves >0){
            val next = ptr.next
            ptr.next = null
            tail.next = ptr
            tail = tail.next
            ptr = next
            moves -= 1
          }
          ptr
        }
    }
}
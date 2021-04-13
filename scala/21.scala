class ListNode(_x: Int = 0, _next: ListNode = null) {
   var next: ListNode = _next
   var x: Int = _x
}
object Solution {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var res: ListNode = null
    var l1Ptr = l1
    var l2Ptr = l2
    val pop = () => {
      val a = if (l1Ptr == null) 101 else l1Ptr.x
      val b = if (l2Ptr == null) 101 else l2Ptr.x
      if (a < b || (a == b && a!=101)){
        val prev = l1Ptr
        l1Ptr = l1Ptr.next
        prev
      } else if (a > b) {
        val prev = l2Ptr
        l2Ptr = l2Ptr.next
        prev
      } else
        null
    }
    var retHead: ListNode = null
    var node:ListNode = null
    do {
      node = pop()
      if (res == null){
        res = node
        retHead = res
      }
      else {
        res.next = node
        res = node
      }
    } while (node != null)
    resHead
  }
}

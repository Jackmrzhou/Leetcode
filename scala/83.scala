class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null) return null
    var resHead:ListNode = null
    var res:ListNode = null
    var iter = head
    while (iter != null) {
      val node =  if (res == null || res.x != iter.x) iter else null
      if (res == null){
        resHead = iter
        res = iter
      }
      else if (node != null){
        res.next = node
        res = res.next
      }
      iter = iter.next
    }
    res.next = null
    resHead
  }
}

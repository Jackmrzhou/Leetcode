object Solution {
    def deleteNode(node: ListNode): Unit = {
        var pNode = node
        while (pNode.next.next != null){
          pNode.x = pNode.next.x
          pNode = pNode.next
        }
        pNode.x = pNode.next.x
        pNode.next = null
    }
}

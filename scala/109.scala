object Solution {
    def sortedListToBST(head: ListNode): TreeNode = {
        if (head == null) null
        else if (head.next == null) TreeNode(head.x)
        else {
          var slow = head
          var fast = head.next.next
          while (fast != null && fast.next != null) {
            slow = slow.next
            fast = fast.next.next
          }
          val root = TreeNode(slow.next.x)
          val r = slow.next.next
          slow.next.next = null
          slow.next = null
          root.left = sortedListToBST(head)
          root.right = sortedListToBST(r)
          root
        }
    }
}
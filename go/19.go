func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummyHead := &ListNode{Next: head}
	remove(dummyHead, n)
	return dummyHead.Next
}

func remove(head *ListNode, n int) int {
	if head == nil {
		return 0
	}
	length := 1 + remove(head.Next, n)
	if length == n+1 {
		head.Next = head.Next.Next
	}
	return length
}
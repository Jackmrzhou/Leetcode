func add(l1 *ListNode, l2 *ListNode, carry int) *ListNode {
	if l1 == nil && l2 == nil {
		if carry != 0 {
			return &ListNode{Val: carry}
		}
		return nil
	}
	if l1 == nil {
		return add(&ListNode{Val: carry}, l2, 0)
	}
	if l2 == nil {
		return add(l1, &ListNode{Val: carry}, 0)
	}
	val := (l1.Val + l2.Val + carry) % 10
	c := (l1.Val + l2.Val + carry) / 10
	cur := &ListNode{
		Val:  val,
		Next: add(l1.Next, l2.Next, c),
	}
	return cur
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	return add(l1, l2, 0)
}
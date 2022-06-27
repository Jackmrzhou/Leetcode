func countAndSay(n int) string {
	cur := "1"
	for i := 1; i < n; i++ {
		next := ""
		for j := 0; j < len(cur); j++ {
			count := 0
			for k := j; k <= len(cur); k++ {
				if k < len(cur) && cur[j] == cur[k] {
					count++
				} else {
					next += fmt.Sprintf("%d", count) + string(cur[j])
					j = k - 1
					break
				}
			}
		}
		cur = next
	}
	return cur
}
func maxArea(height []int) int {
	l, r := 0, len(height)-1
	res := 0
	for l < r {
		res = max((r-l)*min(height[l], height[r]), res)
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return res
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
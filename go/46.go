func permute(nums []int) [][]int {
	if len(nums) == 1 {
		return [][]int{[]int{nums[0]}}
	}
	var ans [][]int
	res := permute(nums[1:])
	for _, p := range res {
		for i := 0; i <= len(p); i++ {
			var newP []int
			for j := 0; j < i; j++ {
				newP = append(newP, p[j])
			}
			newP = append(newP, nums[0])
			for j := i; j < len(p); j++ {
				newP = append(newP, p[j])
			}
			ans = append(ans, newP)
		}
	}
	return ans
}
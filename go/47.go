func swap(nums []int, i, j int) {
	tmp := nums[i]
	nums[i] = nums[j]
	nums[j] = tmp
}

func permuteUnique(nums []int) [][]int {
	return generate(nums, 0, len(nums))
}

func generate(nums []int, l, r int) [][]int {
	if l >= r {
		res := make([]int, len(nums))
		copy(res, nums)
		return [][]int{res}
	}
	var res [][]int
	used := map[int]bool{}
	for i := l; i < r; i++ {
		if used[nums[i]] {
			continue
		}
		used[nums[i]] = true
		swap(nums, l, i)
		res = append(res, generate(nums, l+1, r)...)
		swap(nums, l, i)
	}
	return res
}
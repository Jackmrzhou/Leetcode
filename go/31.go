import "sort"

func nextPermutation(nums []int) {
	lastFound := -1
	greaterIndex := -1
	for i := range nums {
		index := findMinGreater(nums[i+1:], nums[i])
		if index != -1 {
			lastFound = i
			greaterIndex = index + i + 1
		}
	}
	if lastFound == -1 {
		sort.Ints(nums)
		return
	}

	tmp := nums[lastFound]
	nums[lastFound] = nums[greaterIndex]
	nums[greaterIndex] = tmp
	sort.Ints(nums[lastFound+1:])
}

func findMinGreater(nums []int, target int) int {
	index := -1
	for i := range nums {
		if nums[i] > target {
			if index == -1 || nums[index] > nums[i] {
				index = i
			}
		}
	}
	return index
}
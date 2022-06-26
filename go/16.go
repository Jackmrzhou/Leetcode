import "sort"

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)

	res := 100000
	for i := range nums {
		if i != 0 && nums[i] == nums[i-1] {
			continue
		}
		for j, k := i+1, len(nums)-1; j < k; {
			sum := nums[i] + nums[j] + nums[k]
			if abs(res-target) > abs(sum-target) {
				res = sum
			}
			if sum < target {
				j++
			} else {
				k--
			}
		}
	}
	return res
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
import "sort"

func threeSum(nums []int) [][]int {
	if len(nums) < 3 {
		return nil
	}
	sort.Ints(nums)
	res := [][]int{}
	for i := range nums {
		if i != 0 && nums[i] == nums[i-1] {
			continue
		}
		val := twoSum(nums[i+1:], -nums[i])
		if val != nil {
			res = append(res, val...)
		}
	}
	return res
}

func twoSum(nums []int, target int) [][]int {
	var res [][]int
	l, r := 0, len(nums)-1
	for l < r {
		if l != 0 && nums[l] == nums[l-1] {
			l++
			continue
		}
		if r != len(nums)-1 && nums[r] == nums[r+1] {
			r--
			continue
		}
		if nums[l]+nums[r] == target {
			res = append(res, []int{nums[l], nums[r], -target})
			l++
		} else if nums[l]+nums[r] > target {
			r--
		} else {
			l++
		}
	}
	return res
}
func search(nums []int, target int) int {
	return s(nums, 0, len(nums)-1, target)
}

func s(nums []int, l, r, target int) int {
	if l > r {
		return -1
	}
	if l == r {
		if nums[l] == target {
			return l
		}
		return -1
	}
	mid := (r-l)/2 + l
	if nums[mid] == target {
		return mid
	}
	if nums[mid] > nums[l] && target < nums[mid] && target >= nums[l] || nums[mid] < nums[r] && (target < nums[mid] || target > nums[r]) {
		return s(nums, l, mid-1, target)
	} else {
		return s(nums, mid+1, r, target)
	}
}
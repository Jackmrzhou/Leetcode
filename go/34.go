func searchRange(nums []int, target int) []int {
	first = -1
	last = -1
	findFirst(nums, 0, len(nums)-1, target)
	findLast(nums, 0, len(nums)-1, target)
	return []int{first, last}
}

var first = -1

func findFirst(nums []int, l, r, target int) {
	if l > r {
		return
	}
	mid := (r-l)/2 + l
	if nums[mid] >= target {
		if nums[mid] == target && (first == -1 || first > mid) {
			first = mid
		}
		findFirst(nums, l, mid-1, target)
	} else {
		findFirst(nums, mid+1, r, target)
	}
}

var last = -1

func findLast(nums []int, l, r, target int) {
	if l > r {
		return
	}
	mid := (r-l)/2 + l
	if nums[mid] <= target {
		if nums[mid] == target && (last == -1 || last < mid) {
			last = mid
		}
		findLast(nums, mid+1, r, target)
	} else {
		findLast(nums, l, mid-1, target)
	}
}
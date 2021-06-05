object Solution {
    def findMin(nums: Array[Int]): Int = {
        if (nums.length == 1) nums.head 
        else if (nums.head < nums.last) nums.head
        else {
            val mid = nums.length / 2
            if (nums(mid) == nums.last) nums.last
            else if (nums(mid) < nums.head) findMin(nums.slice(0, mid+1))
            else findMin(nums.slice(mid, nums.length))
        }
    }
}
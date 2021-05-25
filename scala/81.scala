object Solution {
    def search(nums: Array[Int], target: Int): Boolean = {
       if (nums.length == 0) {
           false
       } else if (nums.length == 1) {
         nums.head == target  
       } else {
           val mid = nums.length / 2
           if (nums.head == nums.last) {
             if (nums.head == target) true
             else search(nums.slice(1, nums.length - 1), target)
           }
           else if (nums.head < nums.last) {
               if (nums(mid) <= target) search(nums.slice(mid, nums.length), target)
               else search(nums.slice(0, mid), target)
           } else {
               if ((nums(mid) > nums.head && target < nums(mid) && target >= nums.head) || (nums(mid) <= nums.last && (target > nums.last || target < nums(mid)))) search(nums.slice(0, mid), target)
               else search(nums.slice(mid, nums.length), target)
           }
       }
    }
}
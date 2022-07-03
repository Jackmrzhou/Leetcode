package leetcodeJava;

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;
        int l = 0, r = nums.length-1;
        while (l < r) {
            if (nums[l] == target || nums[r] == target) return true;
            while(l+1 <= r && nums[l+1] == nums[l]) l++;
            while(r-1 >= l && nums[r-1] == nums[r]) r--;
            if(l == r) return nums[l] == target;
            var mid = (r-l)/2 + l;
            if (nums[mid] == target) return true;
            if (nums[mid] >= nums[l] && target >= nums[l] && target <= nums[mid] || (nums[mid] <= nums[r] && (target < nums[mid] || target > nums[r])))
                r = mid;
            else l = mid+1;
        }
        return false;
    }
}

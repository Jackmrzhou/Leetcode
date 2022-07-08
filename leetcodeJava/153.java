package leetcodeJava;

class Solution {
    public int findMin(int[] nums) {
        var n = nums.length;
        return find(nums, 0, n-1);
    }
    
    private int find(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        else if (l == r-1) return Math.min(nums[l], nums[r]);
        if (nums[r] > nums[l]) return nums[l];
        var mid = (r-l)/2 + l;
        if (nums[mid] > nums[l]) return find(nums, mid+1, r);
        else return find(nums, l, mid);
    }
}

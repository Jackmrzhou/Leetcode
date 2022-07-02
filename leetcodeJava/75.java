package leetcodeJava;

class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (var i = 0; i <= r; i++) {
            if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                if (nums[i] == 2) {
                    i--;
                    continue;
                }
            }
            if (i >= 0 && nums[i] == 0) {
                swap(nums, i, l);
                l++;
            }
        }
    }
}
